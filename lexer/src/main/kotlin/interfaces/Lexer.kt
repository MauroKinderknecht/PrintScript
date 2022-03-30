package interfaces

import org.austral.ingsis.printscript.common.Token
import java.io.InputStreamReader

interface Lexer {

    fun lex(source: InputStreamReader): List<Token>
}
