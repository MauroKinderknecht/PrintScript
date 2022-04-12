package impl

import data.*
import enums.SyntaxElements
import enums.TokenTypes
import interfaces.Syntax
import interfaces.SyntaxMatcher
import org.austral.ingsis.printscript.common.TokenType
import org.austral.ingsis.printscript.parser.Content
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

abstract class Expression(val matcher: ExpressionMatcher) : Syntax {
    fun parentedExpressionInterval(content: List<Content<String>>) : Pair<Int, Int>? {
        var openIdx = findOpen(content)
        val closeIdx = findClosed(content)
        return if (openIdx != -1 && closeIdx != -1) {
            var nextOpenIdx = findOpen(content.subList(openIdx + 1, closeIdx))
            while (nextOpenIdx != -1) {
                openIdx = nextOpenIdx
                nextOpenIdx = findOpen(content.subList(nextOpenIdx + 1, closeIdx))
            }
            return if (openIdx < closeIdx) Pair(openIdx, closeIdx)
            else null
        }
        else null
    }

    private fun findOpen(content: List<Content<String>>) = find(content, TokenTypes.OPENPAREN)

    private fun findClosed(content: List<Content<String>>) = find(content, TokenTypes.CLOSEPAREN)

    private fun find(content: List<Content<String>>, type: TokenType): Int {
        return content.map { c -> c.token.type }.indexOfFirst{ token -> token == type}
    }
}

class ExpressionMatcher(matchers: List<KClass<out Expression>>) : SyntaxMatcher {

    private val expressions: List<Expression> = matchers.mapNotNull { e -> e.primaryConstructor?.call(this) }

    override fun match(content: List<Content<String>>): AST? =
        expressions.firstNotNullOfOrNull { expression -> expression.parse(content) }
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

// (operation) (identifier | literal | expression)
class UnaryExpression(matcher: ExpressionMatcher) : Expression(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size < 2) return null

        val operation = if (SyntaxElements.UNARYOPERATION.contains(content[0].token.type)) content[0] else null
        val expression = matcher.match(content.subList(2, content.size))

        return if (operation != null && expression != null) UnaryExpressionAST(operation, expression)
        else null
    }

}

// (expression) (operation) (expression)
class ComplexBinaryExpression(matcher: ExpressionMatcher) : Expression(matcher) {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size < 3) return null

        var left = matcher.match(listOf(content[0]))
        val opIdx: Int
        val operation: Content<String>?
        var right = matcher.match(listOf(content[2]))

        if (left != null) {
            opIdx = 1
            if (right == null) {
                val (rStart, rEnd) = parentedExpressionInterval(content.subList(opIdx + 1, content.size)) ?: return null
                right = matcher.match(content.subList(rStart + 1, rEnd))
            }
        } else if (right != null) {
            opIdx = content.size - 2
            val (lStart, lEnd) = parentedExpressionInterval(content) ?: return null
            left = matcher.match(content.subList(lStart + 1, lEnd))
        } else {
            val (lStart, lEnd) = parentedExpressionInterval(content) ?: return null
            left = matcher.match(content.subList(lStart + 1, lEnd))
            opIdx = lEnd + 1
            if (opIdx == content.size) return null
            val (rStart, rEnd) = parentedExpressionInterval(content.subList(opIdx + 1, content.size)) ?: return null
            right = matcher.match(content.subList(rStart + 1, rEnd))
        }

        operation = if (SyntaxElements.BINARYOPERATION.contains(content[opIdx].token.type)) content[opIdx] else null
        return if (left != null && operation != null && right != null) BinaryExpressionAST(left, operation, right)
        else null
    }
}

//class ParenthesisExpression(matcher: ExpressionMatcher): Expression(matcher) {
//    override fun parse(content: List<Content<String>>): AST? {
//        val (start, end) = parentedExpressionInterval(content) ?: return null
//        return if (start == 0 && end == content.size - 1) matcher.match(content.subList(1, content.size - 1))
//        else null
//    }
//}
