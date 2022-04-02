package interfaces

import org.austral.ingsis.printscript.common.Token

interface Lexer {
    fun lex(source: String): List<Token>
}
