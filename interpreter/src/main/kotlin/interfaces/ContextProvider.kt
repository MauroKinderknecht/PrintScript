package interfaces

import org.austral.ingsis.printscript.common.TokenType

interface ContextProvider {
    fun read(variable: String): Pair<TokenType, Any>
    fun write(variable: String, type: TokenType, value: Any): String
    fun create(variable: String, type: TokenType, modifiable: Boolean): String
    fun isEmpty(): Boolean
}
