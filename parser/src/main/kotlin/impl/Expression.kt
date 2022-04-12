package impl

import data.AST
import data.BinaryExpressionAST
import data.IdentifierAST
import data.LiteralAST
import enums.SyntaxElements
import interfaces.Syntax
import interfaces.SyntaxMatcher
import org.austral.ingsis.printscript.parser.Content
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

abstract class Expression(val matcher: ExpressionMatcher) : Syntax

class ExpressionMatcher(matchers: List<KClass<out Expression>>) : SyntaxMatcher {

    private val expressions: List<Expression> = matchers.mapNotNull { e -> e.primaryConstructor?.call(this) }

    override fun match(content: List<Content<String>>): AST? =
        expressions.firstNotNullOfOrNull { expression -> expression.parse(content) }
}

// (identifier | literal)
class UnaryExpression(matcher: ExpressionMatcher) : Expression(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size != 1) return null

        val identifier = if (SyntaxElements.IDENTIFIER.contains(content[0].token.type)) content[0] else null
        val literal = if (SyntaxElements.LITERAL.contains(content[0].token.type)) content[0] else null

        return if (identifier != null) IdentifierAST(identifier)
        else if (literal != null) LiteralAST(literal)
        else null
    }
}

// (identifier | expression) (operation) (identifier | expression)
class BinaryExpression(matcher: ExpressionMatcher) : Expression(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size < 3) return null

        // expression inside parens
        val left = matcher.match(listOf(content[0]))
        val operation = if (SyntaxElements.OPERATION.contains(content[1].token.type)) content[1] else null
        val right = matcher.match(listOf(content[2]))

        return if (left != null && operation != null && right != null) BinaryExpressionAST(left, operation, right)
        else null
    }
}
