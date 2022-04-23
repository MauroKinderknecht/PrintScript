package exception

import org.austral.ingsis.printscript.common.LexicalRange

class InterpreterException(message: String, lexicalRange: LexicalRange?) :
    Exception(if (lexicalRange != null) "$message at $lexicalRange" else message)
