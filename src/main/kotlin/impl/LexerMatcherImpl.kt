package impl

import interfaces.LexerMatcher
import org.austral.ingsis.printscript.common.TokenType
import java.util.regex.Matcher
import java.util.regex.Pattern

class LexerMatcherImpl(private val type: TokenType, regex: String): LexerMatcher {

    val ptrn: Pattern;

    init {
        ptrn = Pattern.compile(regex)
    }

    override fun getPattern(): Pattern = ptrn;

    override fun getTokenType(): TokenType = type;

    override fun getMatcher(input: String): Matcher = ptrn.matcher(input)

}