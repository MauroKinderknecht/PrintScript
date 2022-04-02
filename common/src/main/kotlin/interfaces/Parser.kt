package interfaces

import data.ASTTree
import org.austral.ingsis.printscript.common.Token

interface Parser {
    fun parse(source: String, tokens: List<Token>): ASTTree
}
