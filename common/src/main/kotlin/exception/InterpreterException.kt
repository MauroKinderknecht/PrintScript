package exception

import org.austral.ingsis.printscript.common.LexicalRange

class InterpreterException(message: String, range: LexicalRange? = null) :
    PrintScriptException(message = message, module = "INTERPRETER", range = range)
