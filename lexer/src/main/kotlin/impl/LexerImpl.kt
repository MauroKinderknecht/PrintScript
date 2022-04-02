package impl

import exception.LexerException
import impl.enums.TokenTypes
import interfaces.Lexer
import interfaces.LexerMatcher
import org.austral.ingsis.printscript.common.LexicalRange
import org.austral.ingsis.printscript.common.Token
import java.util.EnumMap
import java.util.regex.Matcher

class LexerImpl : Lexer {

    private var matchers: EnumMap<TokenTypes, LexerMatcher> = EnumMap(TokenTypes::class.java)

    init {
        // Keywords
        matchers[TokenTypes.LET] = LexerMatcherImpl(TokenTypes.LET, "let")
        matchers[TokenTypes.PRINTLN] = LexerMatcherImpl(TokenTypes.PRINTLN, "println")

        // Types
        matchers[TokenTypes.TYPESTRING] = LexerMatcherImpl(TokenTypes.TYPESTRING, "String")
        matchers[TokenTypes.TYPENUMBER] = LexerMatcherImpl(TokenTypes.TYPENUMBER, "Number")

        // Operations
        matchers[TokenTypes.PLUS] = LexerMatcherImpl(TokenTypes.PLUS, "[+]")
        matchers[TokenTypes.MINUS] = LexerMatcherImpl(TokenTypes.MINUS, "[-]")
        matchers[TokenTypes.TIMES] = LexerMatcherImpl(TokenTypes.TIMES, "[*]")
        matchers[TokenTypes.DIVIDEDBY] = LexerMatcherImpl(TokenTypes.DIVIDEDBY, "[/]")
        matchers[TokenTypes.ASSIGNMENT] = LexerMatcherImpl(TokenTypes.ASSIGNMENT, "[=]")
        matchers[TokenTypes.OPENPAREN] = LexerMatcherImpl(TokenTypes.OPENPAREN, "[(]")
        matchers[TokenTypes.CLOSEPAREN] = LexerMatcherImpl(TokenTypes.CLOSEPAREN, "[)]")

        // Declarations
        matchers[TokenTypes.NUMBER] = LexerMatcherImpl(TokenTypes.NUMBER, "-?\\d+\\.?\\d*")
        matchers[TokenTypes.STRING] = LexerMatcherImpl(TokenTypes.STRING, "\".*\"|\'.*\'")

        // Variables
        matchers[TokenTypes.IDENTIFIER] = LexerMatcherImpl(TokenTypes.IDENTIFIER, "[_a-zA-Z][_a-zA-Z0-9]*")

        // Elements
        matchers[TokenTypes.WHITESPACE] = LexerMatcherImpl(TokenTypes.WHITESPACE, " ")
        matchers[TokenTypes.COLON] = LexerMatcherImpl(TokenTypes.COLON, "[:]")
        matchers[TokenTypes.SEMICOLON] = LexerMatcherImpl(TokenTypes.SEMICOLON, "[;]")
        matchers[TokenTypes.EOL] = LexerMatcherImpl(TokenTypes.EOL, "\n")

        matchers[TokenTypes.NOMATCH] = LexerMatcherImpl(TokenTypes.NOMATCH, ".+")
    }

    override fun lex(source: String): List<Token> {
        val matcher = LexerMatcherImpl(matchers.values.toList()).getMatcher(source)
        return getTokens(matcher)
    }

    private fun getTokens(matcher: Matcher): List<Token> {
        val tokens: MutableList<Token> = emptyList<Token>().toMutableList()
        var line = 0
        var position = 0
        var column = 0

        // Find matches and add to token list
        while (matcher.find()) {
            val match = matcher.group()

            // Check matches with tokens
            val matched: Token = matchers.keys.stream()
                .filter { tokenType ->
                    matcher.group(tokenType.type) != null
                }.findFirst().map { tokenType ->
                    if (tokenType == TokenTypes.NOMATCH) throw LexerException("Unexpected token at ${line}:${column}")

                    val endColumn = if (tokenType == TokenTypes.EOL) 0 else column + match.length
                    val endLine = if (tokenType == TokenTypes.EOL) line + 1 else line
                    val endPos = position + match.length

                    val token = Token(tokenType, position, endPos, LexicalRange(column, line, endColumn, endLine))

                    column = endColumn
                    line = endLine
                    position = endPos

                    token
                }.orElseThrow { LexerException("Unexpected token at ${line}:${column}") }

            tokens += matched
        }

        // Add EOF token
        tokens += Token(TokenTypes.EOF, position, position, LexicalRange(column, line, column, line))

        return tokens
    }
}
