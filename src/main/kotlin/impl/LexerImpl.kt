package impl

import exception.LexerException
import interfaces.Lexer
import org.austral.ingsis.printscript.common.LexicalRange
import org.austral.ingsis.printscript.common.Token
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern
import java.util.stream.Collectors


class LexerImpl: Lexer {

    var matchers: EnumMap<TokenTypes, String> = EnumMap(TokenTypes::class.java)

    init {
        // Keywords
        matchers[TokenTypes.LET] = "let"

        // Types
        matchers[TokenTypes.TYPESTRING] = "String"
        matchers[TokenTypes.TYPENUMBER] = "Number"

        // Operations
        matchers[TokenTypes.PLUS] = "[+]"
        matchers[TokenTypes.MINUS] = "[-]"
        matchers[TokenTypes.TIMES] = "[*]"
        matchers[TokenTypes.DIVIDEDBY] = "[/]"
        matchers[TokenTypes.ASSIGNMENT] = "[=]"

        // Declarations
        matchers[TokenTypes.NUMBER] = "-?[0-9.]+"
        matchers[TokenTypes.STRING] = "\\\"([_a-zA-Z0-9 !\\\\/.])*\\\"|'([_a-zA-Z0-9 !\\\\/.])*'"

        // Variables
        matchers[TokenTypes.IDENTIFIER] = "(?:\\b[_a-zA-Z]|\\B\\$)[_\$a-zA-Z0-9]*+"

        // Elements
        matchers[TokenTypes.NEWLINE] = "\n"
        matchers[TokenTypes.WHITESPACE] = " "
        matchers[TokenTypes.COLON] = ":"
        matchers[TokenTypes.SEMICOLON] = ";"
    }

    override fun lex(source: InputStreamReader): List<Token> {
        val matcher = getMatcher(BufferedReader(source).lines().collect(Collectors.joining("\n")))
        val tokens: MutableList<Token> = emptyList<Token>().toMutableList()
        var line = 0
        while (matcher!!.find()) {
            // Skip empty lines
            if (matcher.group().equals("\n")) {
                line++;
                continue;
            }

            // Check matches with tokens
            val matched: Token = matchers.keys.stream().filter {
                tokenType -> matcher.group(tokenType.type) != null
            }.findFirst().map {
                tokenType -> Token(tokenType, 0, 0, LexicalRange(0, 0, 0, 0))
            }.orElseThrow { LexerException("Unexpected token") }
            tokens += matched
        }
        tokens += Token(
            TokenTypes.EOF,
            0,
            0,
            LexicalRange(0, 0, line, line + 1)
        );
        return tokens;
    }

    private fun getMatcher(input: String): Matcher? {
        val x = Arrays.stream(TokenTypes.values()).map { tokenType ->

                java.lang.String.format(
                    "|(?<%s>%s)", tokenType.type, matchers[tokenType]
                )
            }
            .collect(Collectors.joining())
            .substring(1)
        print(x)
        return Pattern.compile(x)
            .matcher(input)
    }

}