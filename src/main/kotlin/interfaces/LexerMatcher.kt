package interfaces

import org.austral.ingsis.printscript.common.TokenType
import java.util.regex.Pattern
import java.util.regex.Matcher

interface LexerMatcher {

    fun getPattern(): Pattern

    fun getTokenType(): TokenType

    fun getMatcher(input: String): Matcher

}