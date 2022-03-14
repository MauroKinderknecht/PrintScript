package impl

import interfaces.LexerMatcher
import org.austral.ingsis.printscript.common.TokenType
import java.util.regex.Matcher
import java.util.regex.Pattern
import java.util.stream.Collectors

class LexerMatcherImpl: LexerMatcher {

    private val ptrn: Pattern

    constructor(type: TokenType, regex: String) {
        ptrn = Pattern.compile(String.format("(?<%s>%s)", type, regex))
    }

    constructor(matchers: List<LexerMatcher>) {
        ptrn = Pattern.compile(matchers.stream().map {
                matcher -> matcher.getPattern().toString()
        }.collect(Collectors.joining("|")))
    }

    override fun getPattern(): Pattern = ptrn

    override fun getMatcher(input: String): Matcher = ptrn.matcher(input)

}