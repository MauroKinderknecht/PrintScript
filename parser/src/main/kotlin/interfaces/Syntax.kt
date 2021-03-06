package interfaces

import data.AST
import org.austral.ingsis.printscript.parser.Content

interface Syntax {
    fun parse(content: List<Content<String>>): AST?
}
