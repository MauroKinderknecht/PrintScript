package impl

import data.AST
import data.ExpressionAST
import data.IdentifierAST
import data.LiteralAST
import enums.SyntaxElements
import interfaces.Syntax
import interfaces.SyntaxMatcher
import org.austral.ingsis.printscript.parser.Content

abstract class Expression() : Syntax

class ExpressionMatcher : SyntaxMatcher {

    private var expressions: MutableList<Expression> = emptyList<Expression>().toMutableList()

    init {
        expressions.add(UnaryExpression(this))
        expressions.add(BinaryExpression(this))
    }

    override fun match(content: List<Content<String>>): AST? =
        expressions.firstNotNullOfOrNull { expression -> expression.parse(content) }
}

// (identifier | literal)
class UnaryExpression(private val matcher: ExpressionMatcher) : Expression() {
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
class BinaryExpression(private val matcher: ExpressionMatcher) : Expression() {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size < 3) return null

        // expression inside parens
        val left = matcher.match(listOf(content[0]))
        val operation = if (SyntaxElements.OPERATION.contains(content[1].token.type)) content[1] else null
        val right = matcher.match(listOf(content[2]))

        return if (left != null && operation != null && right != null) ExpressionAST(left, operation, right)
        else null
    }
}
