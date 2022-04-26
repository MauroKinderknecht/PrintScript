package enums

import interfaces.SyntaxElement
import org.austral.ingsis.printscript.common.TokenType

enum class SyntaxElements(override val types: List<TokenType>) : SyntaxElement {

    TYPE(listOf(TokenTypes.TYPESTRING, TokenTypes.TYPENUMBER, TokenTypes.TYPEBOOLEAN)),

    VARIABLE(listOf(TokenTypes.LET, TokenTypes.CONST)),

    MULTDIVOPERATION(listOf(TokenTypes.TIMES, TokenTypes.DIVIDEDBY)),

    ADDSUBTOPERATION(listOf(TokenTypes.PLUS, TokenTypes.MINUS)),

    UNARYOPERATION(listOf(TokenTypes.MINUS)),

    IDENTIFIER(listOf(TokenTypes.IDENTIFIER)),

    ASSIGNMENT(listOf(TokenTypes.ASSIGNMENT)),

    TYPEASSIGNMENT(listOf(TokenTypes.COLON)),

    VOIDFUNCTION(listOf(TokenTypes.PRINTLN)),

    FUNCTIONCALL(listOf(TokenTypes.READINPUT)),

    LITERAL(listOf(TokenTypes.STRING, TokenTypes.NUMBER, TokenTypes.BOOLEAN)),

    EOF(listOf(TokenTypes.EOF)),

    NOTUSEFUL(listOf(TokenTypes.EOL, TokenTypes.WHITESPACE)),

    END(listOf(TokenTypes.SEMICOLON)),

    IF(listOf(TokenTypes.IF)),

    ELSE(listOf(TokenTypes.ELSE)),
}
