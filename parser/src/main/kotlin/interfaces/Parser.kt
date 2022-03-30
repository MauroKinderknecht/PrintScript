package interfaces

import org.austral.ingsis.printscript.common.Token

interface Parser {

    fun parse(source: List<Token>): ASTTree

}