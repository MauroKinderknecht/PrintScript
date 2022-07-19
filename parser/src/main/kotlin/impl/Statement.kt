package impl

import data.*
import enums.SyntaxElements
import enums.TokenTypes
import interfaces.Syntax
import interfaces.SyntaxMatcher
import org.austral.ingsis.printscript.parser.Content
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

abstract class Statement(val matcher: StatementMatcher) : Syntax

class StatementMatcher(matchers: List<KClass<out Statement>>, private val expressionMatcher: ExpressionMatcher) : SyntaxMatcher {

    private var statements: List<Statement> = matchers.mapNotNull { it.primaryConstructor?.call(this) }

    // return first not null parsed ast
    override fun match(content: List<Content<String>>): AST? =
        statements.firstNotNullOfOrNull { it.parse(content) }

    fun matchExpression(content: List<Content<String>>): AST? = expressionMatcher.match(content)

    fun matchCodeBlock(content: List<Content<String>>): AST? {
        if (content.size < 3) return null

        val openBrace = content[0].token.type == TokenTypes.OPENBRACE
        val statements = splitOn(content.subList(1, content.size - 1)) { !SyntaxElements.END.contains(it.token.type) }.mapNotNull { match(it) }
        val closeBrace = content[content.size - 1].token.type == TokenTypes.CLOSEBRACE

        return if (openBrace && statements.isNotEmpty() && closeBrace) BlockAST(statements)
        else null
    }

    private fun <T> splitOn(list: List<T>, condition: (T) -> Boolean): List<List<T>> {
        var leftToSplit = list
        val groups = mutableListOf<List<T>>()
        var currentGroup: List<T>
        while (leftToSplit.isNotEmpty()) {
            currentGroup = leftToSplit.takeWhile { condition(it) }
            groups.add(currentGroup)
            leftToSplit = if (currentGroup.size == leftToSplit.size) listOf()
            else leftToSplit.subList(currentGroup.size + 1, leftToSplit.size)
        }
        return groups
    }
}

// (variable) (identifier) (type_assignment) (type) (end)
class DeclarationStatement(matcher: StatementMatcher) : Statement(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size != 4) return null

        val variable = if (SyntaxElements.VARIABLE.contains(content[0].token.type)) content[0] else null
        val identifier = if (SyntaxElements.IDENTIFIER.contains(content[1].token.type)) content[1] else null
        val colon = SyntaxElements.TYPEASSIGNMENT.contains(content[2].token.type)
        val type = if (SyntaxElements.TYPE.contains(content[3].token.type)) content[3] else null

        return if (variable != null && identifier != null && colon && type != null) DeclarationAST(variable, identifier, type)
        else null
    }
}

// (identifier) (assignment) (expression)
class AssignationStatement(matcher: StatementMatcher) : Statement(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size < 3) return null

        val identifier = if (SyntaxElements.IDENTIFIER.contains(content[0].token.type)) content[0] else null
        val assignment = SyntaxElements.ASSIGNMENT.contains(content[1].token.type)
        val expression = matcher.matchExpression(content.subList(2, content.size))

        return if (identifier != null && assignment && expression != null) AssignationAST(VariableAST(identifier), expression)
        else null
    }
}

// (variable) (identifier) (type_assignment) (type) (assignment) (expression)
class DeclarationAssignationStatement(matcher: StatementMatcher) : Statement(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size < 6) return null

        val variable = if (SyntaxElements.VARIABLE.contains(content[0].token.type)) content[0] else null
        val identifier = if (SyntaxElements.IDENTIFIER.contains(content[1].token.type)) content[1] else null
        val colon = SyntaxElements.TYPEASSIGNMENT.contains(content[2].token.type)
        val type = if (SyntaxElements.TYPE.contains(content[3].token.type)) content[3] else null
        val assignment = SyntaxElements.ASSIGNMENT.contains(content[4].token.type)
        val expression = matcher.matchExpression(content.subList(5, content.size))

        return if (variable != null && identifier != null && colon && type != null && assignment && expression != null)
            AssignationAST(DeclarationAST(variable, identifier, type), expression)
        else null
    }
}

// (println) ( ( ) (expression) ( ) )
class FunctionStatement(matcher: StatementMatcher) : Statement(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size < 3) return null

        val function = if (SyntaxElements.VOIDFUNCTION.contains(content[0].token.type)) content[0] else null
        val open = content[1].token.type == TokenTypes.OPENPAREN
        val expression = matcher.matchExpression(content.subList(2, content.size - 1))
        val close = content[content.size - 1].token.type == TokenTypes.CLOSEPAREN

        return if (function != null && open && expression != null && close) VoidFunctionAST(function, expression)
        else null
    }
}

// (if) ( ( ) (condition) ( ) ) ( { ) ( routine ) ( } )
class IfStatement(matcher: StatementMatcher) : Statement(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size < 7) return null

        val ifToken = content[0].token.type == TokenTypes.IF
        val openParen = content[1].token.type == TokenTypes.OPENPAREN
        val condition = matcher.matchExpression(content.subList(2, 3))
        val closeParen = content[3].token.type == TokenTypes.CLOSEPAREN
        val truthyBlock = matcher.matchCodeBlock(content.subList(4, content.size))

        return if (ifToken && openParen && condition != null && closeParen && truthyBlock != null) IfAST(condition, truthyBlock)
        else null
    }
}

// (if) ( ( ) (condition) ( ) ) ( { ) ( routine ) ( } ) (else) ( { ) ( routine ) ( } )
class IfElseStatement(matcher: StatementMatcher) : Statement(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size < 11) return null

        val indexOfElse = content.indexOfFirst { SyntaxElements.ELSE.contains(it.token.type) }
        if (indexOfElse == -1) return null

        val ifToken = SyntaxElements.IF.contains(content[0].token.type)
        val openParen = content[1].token.type == TokenTypes.OPENPAREN
        val condition = matcher.matchExpression(content.subList(2, 3))
        val closeParen = content[3].token.type == TokenTypes.CLOSEPAREN
        val truthyBlock = matcher.matchCodeBlock(content.subList(4, indexOfElse))
        val falsyBlock = matcher.matchCodeBlock(content.subList(indexOfElse + 1, content.size))

        return if (ifToken && openParen && condition != null && closeParen && truthyBlock != null && falsyBlock != null)
            IfElseAST(condition, truthyBlock, falsyBlock)
        else null
    }
}
