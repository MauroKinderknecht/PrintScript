package interfaces

import data.AST
import org.austral.ingsis.printscript.parser.Content

interface SyntaxMatcher {
    fun match(content: List<Content<String>>): AST?
}
