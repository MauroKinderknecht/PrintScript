package enums

import interfaces.SyntaxElement
import org.austral.ingsis.printscript.common.TokenType

enum class SyntaxElements(override val types: List<TokenType>) : SyntaxElement {

    TYPE(listOf(TokenTypes.TYPESTRING, TokenTypes.TYPENUMBER)),

    VARIABLE(listOf(TokenTypes.LET)),

    OPERATION(listOf(TokenTypes.PLUS, TokenTypes.MINUS, TokenTypes.TIMES, TokenTypes.DIVIDEDBY)),

    OPENPAREN(listOf(TokenTypes.OPENPAREN)),

    CLOSEPAREN(listOf(TokenTypes.CLOSEPAREN)),

    IDENTIFIER(listOf(TokenTypes.IDENTIFIER)),

    ASSIGNMENT(listOf(TokenTypes.ASSIGNMENT)),

    TYPEASSIGNMENT(listOf(TokenTypes.COLON)),

    FUNCTION(listOf(TokenTypes.PRINTLN)),

    LITERAL(listOf(TokenTypes.STRING, TokenTypes.NUMBER)),

    EOF(listOf(TokenTypes.EOF)),

    NOTUSEFUL(listOf(TokenTypes.EOL, TokenTypes.WHITESPACE)),

    END(listOf(TokenTypes.SEMICOLON))
}
