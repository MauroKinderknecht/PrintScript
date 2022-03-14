package interfaces

import java.util.regex.Pattern
import java.util.regex.Matcher

interface LexerMatcher {

    fun getPattern(): Pattern

    fun getMatcher(input: String): Matcher

}