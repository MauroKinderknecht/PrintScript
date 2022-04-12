package interfaces

import data.AST
import org.austral.ingsis.printscript.common.Token

interface Parser {
    fun parse(source: String, tokens: List<Token>): AST
}
