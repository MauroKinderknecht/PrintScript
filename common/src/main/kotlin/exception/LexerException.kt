package exception

import org.austral.ingsis.printscript.common.LexicalRange

class LexerException(lexicalRange: LexicalRange) : PrintScriptException("Couldn't match token at $lexicalRange")
