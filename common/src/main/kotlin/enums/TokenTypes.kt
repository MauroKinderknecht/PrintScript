package enums

import org.austral.ingsis.printscript.common.TokenType

enum class TokenTypes(override val type: String) : TokenType {
    // Variables
    IDENTIFIER("IDENTIFIER"),

    // Keywords
    LET("LET"),
    CONST("CONST"),
    PRINTLN("PRINTLN"),
    READINPUT("READINPUT"),
    IF("IF"),
    ELSE("ELSE"),

    // Types
    TYPESTRING("TYPESTRING"),
    TYPENUMBER("TYPENUMBER"),
    TYPEBOOLEAN("TYPEBOOLEAN"),

    // Operations
    PLUS("PLUS"),
    MINUS("MINUS"),
    TIMES("TIMES"),
    DIVIDEDBY("DIVIDEDBY"),
    ASSIGNMENT("ASSIGNMENT"),
    OPENPAREN("OPENPAREN"),
    CLOSEPAREN("CLOSEPAREN"),
    OPENBRACE("OPENBRACE"),
    CLOSEBRACE("CLOSEBRACE"),

    // Declarations
    NUMBER("NUMBER"),
    STRING("STRING"),
    BOOLEAN("BOOLEAN"),

    // Elements
    WHITESPACE("WHITESPACE"),
    EOF("EOF"),
    EOL("EOL"),
    COLON("COLON"),
    SEMICOLON("SEMICOLON"),

    // No match token
    NOMATCH("NOMATCH")
}
