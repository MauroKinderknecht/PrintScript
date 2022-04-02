package impl.enums

import org.austral.ingsis.printscript.common.TokenType

enum class TokenTypes(override val type: String) : TokenType {
    // Keywords - Should be declared first to match first
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

    // Variables
    IDENTIFIER("IDENTIFIER"),

    // Elements
    WHITESPACE("WHITESPACE"),
    EOF("EOF"),
    EOL("EOL"),
    COLON("COLON"),
    SEMICOLON("SEMICOLON")
}
