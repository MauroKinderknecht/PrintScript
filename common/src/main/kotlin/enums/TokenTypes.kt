package enums

import org.austral.ingsis.printscript.common.TokenType

enum class TokenTypes(override val type: String) : TokenType {
    // Variables
    IDENTIFIER("IDENTIFIER"),

    // Keywords
    LET("LET"),
    PRINTLN("PRINTLN"),

    // Types
    TYPESTRING("TYPESTRING"),
    TYPENUMBER("TYPENUMBER"),

    // Operations
    PLUS("PLUS"),
    MINUS("MINUS"),
    TIMES("TIMES"),
    DIVIDEDBY("DIVIDEDBY"),
    ASSIGNMENT("ASSIGNMENT"),
    OPENPAREN("OPENPAREN"),
    CLOSEPAREN("CLOSEPAREN"),

    // Declarations
    NUMBER("NUMBER"),
    STRING("STRING"),

    // Elements
    WHITESPACE("WHITESPACE"),
    EOF("EOF"),
    EOL("EOL"),
    COLON("COLON"),
    SEMICOLON("SEMICOLON"),

    // No match token
    NOMATCH("NOMATCH")
}
