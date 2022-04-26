package exception

import org.austral.ingsis.printscript.common.LexicalRange

class ParserException(message: String, range: LexicalRange? = null) :
    PrintScriptException(message = message, module = "PARSER", range = range)
