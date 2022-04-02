package impl

import interfaces.LexerMatcher
import org.austral.ingsis.printscript.common.TokenType
import java.util.regex.Matcher
import java.util.regex.Pattern
import java.util.stream.Collectors

class LexerMatcherImpl : LexerMatcher {

    private val pattern: Pattern

    constructor(type: TokenType, regex: String) {
        pattern = Pattern.compile(String.format("(?<%s>%s)", type, regex))
    }

    constructor(matchers: List<LexerMatcher>) {
        pattern = Pattern.compile(
            matchers.stream().map {
                    matcher ->
                matcher.getPattern().toString()
            }.collect(Collectors.joining("|"))
        )
    }

    override fun getPattern(): Pattern = pattern

    override fun getMatcher(input: String): Matcher = pattern.matcher(input)
}
