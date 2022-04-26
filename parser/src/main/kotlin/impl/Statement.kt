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

    private var statements: List<Statement> = matchers.mapNotNull { e -> e.primaryConstructor?.call(this) }

    // return first not null parsed ast
    override fun match(content: List<Content<String>>): AST? =
        statements.firstNotNullOfOrNull { statement -> statement.parse(content) }

    fun matchExpression(content: List<Content<String>>): AST? = expressionMatcher.match(content)

    fun matchCodeBlock(content: List<Content<String>>): AST? {
        if (content.size < 3) return null

        val openBrace = if (content[0].token.type == TokenTypes.OPENBRACE) content[0] else null
        val statements = match(content.subList(1, content.size - 1))
        val closeBrace = if (content[content.size - 1].token.type == TokenTypes.CLOSEBRACE) content[content.size - 1] else null

        return if (openBrace != null && statements != null && closeBrace != null)
            BlockAST(listOf(statements))
        else null
    }
}

// (variable) (identifier) (type_assignment) (type) (end)
class DeclarationStatement(matcher: StatementMatcher) : Statement(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size != 4) return null

        val variable = if (SyntaxElements.VARIABLE.contains(content[0].token.type)) content[0] else null
        val identifier = if (SyntaxElements.IDENTIFIER.contains(content[1].token.type)) content[1] else null
        val colon = if (SyntaxElements.TYPEASSIGNMENT.contains(content[2].token.type)) content[2] else null
        val type = if (SyntaxElements.TYPE.contains(content[3].token.type)) content[3] else null

        return if (variable != null && identifier != null && colon != null && type != null)
            DeclarationAST(variable, identifier, type)
        else null
    }
}

// (identifier) (assignment) (expression)
class AssignationStatement(matcher: StatementMatcher) : Statement(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size < 3) return null

        val identifier = if (SyntaxElements.IDENTIFIER.contains(content[0].token.type)) content[0] else null
        val assignment = if (SyntaxElements.ASSIGNMENT.contains(content[1].token.type)) content[1] else null
        val expression = matcher.matchExpression(content.subList(2, content.size))

        return if (identifier != null && assignment != null && expression != null)
            AssignationAST(VariableAST(identifier), expression)
        else null
    }
}

// (variable) (identifier) (type_assignment) (type) (assignment) (expression)
class DeclarationAssignationStatement(matcher: StatementMatcher) : Statement(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size < 6) return null

        val variable = if (SyntaxElements.VARIABLE.contains(content[0].token.type)) content[0] else null
        val identifier = if (SyntaxElements.IDENTIFIER.contains(content[1].token.type)) content[1] else null
        val colon = if (SyntaxElements.TYPEASSIGNMENT.contains(content[2].token.type)) content[2] else null
        val type = if (SyntaxElements.TYPE.contains(content[3].token.type)) content[3] else null
        val assignment = if (SyntaxElements.ASSIGNMENT.contains(content[4].token.type)) content[4] else null
        val expression = matcher.matchExpression(content.subList(5, content.size))

        return if (variable != null && identifier != null && colon != null && type != null &&
            assignment != null && expression != null
        )
            AssignationAST(
                DeclarationAST(variable, identifier, type),
                expression
            )
        else null
    }
}

// (println) ( ( ) (expression) ( ) )
class FunctionStatement(matcher: StatementMatcher) : Statement(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size < 3) return null

        val function = if (SyntaxElements.FUNCTION.contains(content[0].token.type)) content[0] else null
        val open = if (content[1].token.type == TokenTypes.OPENPAREN) content[1] else null
        val expression = matcher.matchExpression(content.subList(2, content.size - 1))
        val close = if (content[content.size - 1].token.type == TokenTypes.CLOSEPAREN) content[content.size - 1] else null

        return if (function != null && open != null && close != null)
            FunctionAST(function, expression)
        else null
    }
}

// (if) ( ( ) (condition) ( ) ) ( { ) ( routine ) ( } )
class IfStatement(matcher: StatementMatcher) : Statement(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size < 5) return null

        val ifToken = if (content[0].token.type == TokenTypes.IF) content[0] else null
        val openParen = if (content[1].token.type == TokenTypes.OPENPAREN) content[1] else null
        val condition = matcher.matchExpression(content.subList(2, 3))
        val closeParen = if (content[3].token.type == TokenTypes.CLOSEPAREN) content[3] else null
        val truthyBlock = matcher.matchCodeBlock(content.subList(4, content.size))

        println(content.takeWhile { t -> t.token.type !== TokenTypes.SEMICOLON })

        // println(groupConsecutiveBy(content){ t -> !SyntaxElements.END.contains(t.token.type) })

        return if (ifToken != null && openParen != null && condition != null && closeParen != null && truthyBlock != null)
            IfAST(condition, ProgramAST(listOf()))
        else null
    }
}

// (if) ( ( ) (condition) ( ) ) ( { ) ( routine ) ( } ) (else) ( { ) ( routine ) ( } )
class IfElseStatement(matcher: StatementMatcher) : Statement(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size < 11) return null
        return null
    }
}
