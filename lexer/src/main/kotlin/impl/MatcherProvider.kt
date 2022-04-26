package impl

import enums.PrintScriptVersion
import enums.TokenTypes
import interfaces.LexerMatcher
import java.util.*

class MatcherProvider {

    companion object {

        fun getMatchers(version: PrintScriptVersion): EnumMap<TokenTypes, LexerMatcher> {
            val matchers: EnumMap<TokenTypes, LexerMatcher> = EnumMap(TokenTypes::class.java)
            return when (version) {
                PrintScriptVersion.V1_1 -> {
                    // Keywords
                    matchers[TokenTypes.LET] = LexerMatcherImpl(TokenTypes.LET, "let")
                    matchers[TokenTypes.CONST] = LexerMatcherImpl(TokenTypes.CONST, "const")
                    matchers[TokenTypes.PRINTLN] = LexerMatcherImpl(TokenTypes.PRINTLN, "println")
                    matchers[TokenTypes.READINPUT] = LexerMatcherImpl(TokenTypes.READINPUT, "readInput")
                    matchers[TokenTypes.IF] = LexerMatcherImpl(TokenTypes.IF, "if")
                    matchers[TokenTypes.ELSE] = LexerMatcherImpl(TokenTypes.ELSE, "else")

                    // Types
                    matchers[TokenTypes.TYPESTRING] = LexerMatcherImpl(TokenTypes.TYPESTRING, "String|string")
                    matchers[TokenTypes.TYPENUMBER] = LexerMatcherImpl(TokenTypes.TYPENUMBER, "Number|number")
                    matchers[TokenTypes.TYPEBOOLEAN] = LexerMatcherImpl(TokenTypes.TYPEBOOLEAN, "Boolean|boolean")

                    // Operations
                    matchers[TokenTypes.PLUS] = LexerMatcherImpl(TokenTypes.PLUS, "[+]")
                    matchers[TokenTypes.MINUS] = LexerMatcherImpl(TokenTypes.MINUS, "[-]")
                    matchers[TokenTypes.TIMES] = LexerMatcherImpl(TokenTypes.TIMES, "[*]")
                    matchers[TokenTypes.DIVIDEDBY] = LexerMatcherImpl(TokenTypes.DIVIDEDBY, "[/]")
                    matchers[TokenTypes.ASSIGNMENT] = LexerMatcherImpl(TokenTypes.ASSIGNMENT, "[=]")
                    matchers[TokenTypes.OPENPAREN] = LexerMatcherImpl(TokenTypes.OPENPAREN, "[(]")
                    matchers[TokenTypes.CLOSEPAREN] = LexerMatcherImpl(TokenTypes.CLOSEPAREN, "[)]")
                    matchers[TokenTypes.OPENBRACE] = LexerMatcherImpl(TokenTypes.OPENBRACE, "[{]")
                    matchers[TokenTypes.CLOSEBRACE] = LexerMatcherImpl(TokenTypes.CLOSEBRACE, "[}]")

                    // Declarations
                    matchers[TokenTypes.NUMBER] = LexerMatcherImpl(TokenTypes.NUMBER, "-?\\d+\\.?\\d*")
                    matchers[TokenTypes.STRING] = LexerMatcherImpl(TokenTypes.STRING, "\".*\"|\'.*\'")
                    matchers[TokenTypes.BOOLEAN] = LexerMatcherImpl(TokenTypes.BOOLEAN, "true|false")

                    // Variables
                    matchers[TokenTypes.IDENTIFIER] = LexerMatcherImpl(
                        TokenTypes.IDENTIFIER, "[_a-zA-Z][_a-zA-Z0-9]*",
                        listOf(
                            matchers[TokenTypes.LET]!!,
                            matchers[TokenTypes.CONST]!!,
                            matchers[TokenTypes.PRINTLN]!!,
                            matchers[TokenTypes.READINPUT]!!,
                            matchers[TokenTypes.IF]!!,
                            matchers[TokenTypes.ELSE]!!,
                            matchers[TokenTypes.TYPESTRING]!!,
                            matchers[TokenTypes.TYPENUMBER]!!,
                            matchers[TokenTypes.TYPEBOOLEAN]!!,
                            matchers[TokenTypes.BOOLEAN]!!
                        )
                    )

                    // Elements
                    matchers[TokenTypes.WHITESPACE] = LexerMatcherImpl(TokenTypes.WHITESPACE, " ")
                    matchers[TokenTypes.COLON] = LexerMatcherImpl(TokenTypes.COLON, "[:]")
                    matchers[TokenTypes.SEMICOLON] = LexerMatcherImpl(TokenTypes.SEMICOLON, "[;]")
                    matchers[TokenTypes.EOL] = LexerMatcherImpl(TokenTypes.EOL, "\n")

                    // No match token
                    matchers[TokenTypes.NOMATCH] = LexerMatcherImpl(TokenTypes.NOMATCH, ".+")

                    matchers
                }

                PrintScriptVersion.V1_0 -> {
                    // Keywords
                    matchers[TokenTypes.LET] = LexerMatcherImpl(TokenTypes.LET, "let")
                    matchers[TokenTypes.PRINTLN] = LexerMatcherImpl(TokenTypes.PRINTLN, "println")

                    // Types
                    matchers[TokenTypes.TYPESTRING] = LexerMatcherImpl(TokenTypes.TYPESTRING, "String|string")
                    matchers[TokenTypes.TYPENUMBER] = LexerMatcherImpl(TokenTypes.TYPENUMBER, "Number|number")

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
                    matchers[TokenTypes.IDENTIFIER] = LexerMatcherImpl(
                        TokenTypes.IDENTIFIER, "[_a-zA-Z][_a-zA-Z0-9]*",
                        listOf(
                            matchers[TokenTypes.LET]!!,
                            matchers[TokenTypes.PRINTLN]!!,
                            matchers[TokenTypes.TYPESTRING]!!,
                            matchers[TokenTypes.TYPENUMBER]!!
                        )
                    )

                    // Elements
                    matchers[TokenTypes.WHITESPACE] = LexerMatcherImpl(TokenTypes.WHITESPACE, " ")
                    matchers[TokenTypes.COLON] = LexerMatcherImpl(TokenTypes.COLON, "[:]")
                    matchers[TokenTypes.SEMICOLON] = LexerMatcherImpl(TokenTypes.SEMICOLON, "[;]")
                    matchers[TokenTypes.EOL] = LexerMatcherImpl(TokenTypes.EOL, "\n")

                    // No match token
                    matchers[TokenTypes.NOMATCH] = LexerMatcherImpl(TokenTypes.NOMATCH, ".+")

                    matchers
                }
            }
        }
    }
}
