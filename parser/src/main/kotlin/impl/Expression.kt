package impl

import data.*
import enums.SyntaxElements
import enums.TokenTypes
import interfaces.Syntax
import interfaces.SyntaxMatcher
import org.austral.ingsis.printscript.parser.Content
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

abstract class Expression(val matcher: ExpressionMatcher) : Syntax {
    fun indexOfOperation(content: List<Content<String>>, syntaxElements: SyntaxElements): Int? {
        var parens = 0
        for ((index, element) in content.withIndex()) {
            if (element.token.type == TokenTypes.OPENPAREN) parens++
            else if (element.token.type == TokenTypes.CLOSEPAREN) parens--
            else if (parens == 0 && syntaxElements.contains(element.token.type)) return index
        }
        return null
    }
}

class ExpressionMatcher(matchers: List<KClass<out Expression>>) : SyntaxMatcher {

    private val expressions: List<Expression> = matchers.mapNotNull { e -> e.primaryConstructor?.call(this) }

    override fun match(content: List<Content<String>>): AST? =
        expressions.firstNotNullOfOrNull { expression -> expression.parse(content) }

    fun match(content: List<Content<String>>, without: List<KClass<out Expression>>): AST? =
        expressions.filter { expression -> !without.contains(expression::class) }.firstNotNullOfOrNull { expression -> expression.parse(content) }
}

// (identifier)
class IdentifierExpression(matcher: ExpressionMatcher) : Expression(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size != 1) return null

        val identifier = if (SyntaxElements.IDENTIFIER.contains(content[0].token.type)) content[0] else null

        return if (identifier != null) IdentifierAST(identifier)
        else null
    }
}

// (literal)
class LiteralExpression(matcher: ExpressionMatcher) : Expression(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size != 1) return null

        val literal = if (SyntaxElements.LITERAL.contains(content[0].token.type)) content[0] else null

        return if (literal != null) LiteralAST(literal)
        else null
    }
}

// ( - ) (expression)
class UnaryExpression(matcher: ExpressionMatcher) : Expression(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size < 2) return null

        val operation = if (SyntaxElements.UNARYOPERATION.contains(content[0].token.type)) content[0] else null
        val expression = matcher.match(content.subList(2, content.size))

        return if (operation != null && expression != null) UnaryExpressionAST(operation, expression)
        else null
    }
}

// (expression) ( * | / ) (expression)
class MultDivExpression(matcher: ExpressionMatcher) : Expression(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size < 3) return null

        val operation = indexOfOperation(content, SyntaxElements.MULTDIVOPERATION) ?: return null
        val left = matcher.match(content.subList(0, operation), listOf(AddSubtExpression::class))
        val right = matcher.match(content.subList(operation + 1, content.size), listOf(AddSubtExpression::class))

        return if (left != null && right != null) BinaryExpressionAST(left, content[operation], right)
        else null
    }
}

// (expression) ( + | - ) (expression)
class AddSubtExpression(matcher: ExpressionMatcher) : Expression(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size < 3) return null

        val operation = indexOfOperation(content, SyntaxElements.ADDSUBTOPERATION) ?: return null
        val left = matcher.match(content.subList(0, operation))
        val right = matcher.match(content.subList(operation + 1, content.size))

        return if (left != null && right != null) BinaryExpressionAST(left, content[operation], right)
        else null
    }
}

// ( ( ) (expression) ( ) )
class ParenthesisExpression(matcher: ExpressionMatcher) : Expression(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size < 3) return null

        val openParen = TokenTypes.OPENPAREN == content[0].token.type
        val expression = matcher.match(content.subList(1, content.size - 1))
        val closeParen = TokenTypes.CLOSEPAREN == content[content.size - 1].token.type

        return if (openParen && closeParen && expression != null) expression
        else null
    }
}
