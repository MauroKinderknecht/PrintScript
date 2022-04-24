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
                PrintScriptVersion.V1_0 -> {
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

                    matchers
                }
            }
        }
    }
}
