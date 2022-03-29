package impl

import exception.LexerException
import interfaces.Lexer
import interfaces.LexerMatcher
import org.austral.ingsis.printscript.common.LexicalRange
import org.austral.ingsis.printscript.common.Token
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import java.util.stream.Collectors

class LexerImpl: Lexer {

    private var matchers: EnumMap<TokenTypes, LexerMatcher> = EnumMap(TokenTypes::class.java)

    init {
        // Keywords
        matchers[TokenTypes.LET] = LexerMatcherImpl(TokenTypes.LET, "let")
        matchers[TokenTypes.PRINTLN] = LexerMatcherImpl(TokenTypes.PRINTLN, "println")

        // Types
        matchers[TokenTypes.TYPESTRING] = LexerMatcherImpl(TokenTypes.TYPESTRING,"string")
        matchers[TokenTypes.TYPENUMBER] = LexerMatcherImpl(TokenTypes.TYPENUMBER, "number")

        // Operations
        matchers[TokenTypes.PLUS] = LexerMatcherImpl(TokenTypes.PLUS, "[+]")
        matchers[TokenTypes.MINUS] = LexerMatcherImpl(TokenTypes.MINUS, "[-]")
        matchers[TokenTypes.TIMES] = LexerMatcherImpl(TokenTypes.TIMES, "[*]")
        matchers[TokenTypes.DIVIDEDBY] = LexerMatcherImpl(TokenTypes.DIVIDEDBY, "[/]")
        matchers[TokenTypes.ASSIGNMENT] = LexerMatcherImpl(TokenTypes.ASSIGNMENT, "[=]")
        matchers[TokenTypes.OPENPAREN] = LexerMatcherImpl(TokenTypes.OPENPAREN, "[(]")
        matchers[TokenTypes.CLOSEPAREN] = LexerMatcherImpl(TokenTypes.CLOSEPAREN, "[)]")

        // Declarations
        matchers[TokenTypes.NUMBER] = LexerMatcherImpl(TokenTypes.NUMBER, "-?\d+\.?\d*")
        matchers[TokenTypes.STRING] = LexerMatcherImpl(TokenTypes.STRING, "\".*\"|\'.*\'")

        // Variables
        matchers[TokenTypes.IDENTIFIER] = LexerMatcherImpl(TokenTypes.IDENTIFIER, "(?:\b[_a-zA-Z]|\B\$)[_\$a-zA-Z0-9]*+")

        // Elements
        matchers[TokenTypes.WHITESPACE] = LexerMatcherImpl(TokenTypes.WHITESPACE, " ")
        matchers[TokenTypes.COLON] = LexerMatcherImpl(TokenTypes.COLON, "[:]")
        matchers[TokenTypes.SEMICOLON] = LexerMatcherImpl(TokenTypes.SEMICOLON, "[;]")
    }

    override fun lex(source: InputStreamReader): List<Token> {
        val matcher = LexerMatcherImpl(matchers.values.toList()).getMatcher(
            BufferedReader(source).lines().collect(Collectors.joining("\n"))
        )
        val tokens: MutableList<Token> = emptyList<Token>().toMutableList()
        var line = 0
        var position = 0
        var column = 0
        while (matcher.find()) {
            val match = matcher.group()

            // Skip empty lines
            if (match.equals("\n")) {
                line++
                column = 0
                continue
            }

            // Check matches with tokens
            val matched: Token = matchers.keys.stream().filter {
                tokenType -> matcher.group(tokenType.type) != null
            }.findFirst().map {
                tokenType -> Token(
                    tokenType,
                    position,
                    position + match.length,
                    LexicalRange(column, line, column + match.length, line))
            }.orElseThrow { LexerException("Unexpected token") }
            tokens += matched
            column += match.length
            position += match.length
        }
        tokens += Token(
            TokenTypes.EOF,
            position,
            position,
            LexicalRange(column, line, column, line)
        )
        //tokens.map { token -> println(token) }
        return tokens
    }
}