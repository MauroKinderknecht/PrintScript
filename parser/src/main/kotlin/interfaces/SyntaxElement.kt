package interfaces

import org.austral.ingsis.printscript.common.TokenType

interface SyntaxElement {
    val types: List<TokenType>

    fun contains(type: TokenType): Boolean = type in types

    fun get(): Array<TokenType> = types.toTypedArray()
}
