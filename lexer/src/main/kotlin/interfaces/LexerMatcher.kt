package interfaces

import java.util.regex.Matcher
import java.util.regex.Pattern

interface LexerMatcher {

    fun getPattern(): Pattern

    fun getMatcher(input: String): Matcher
}
