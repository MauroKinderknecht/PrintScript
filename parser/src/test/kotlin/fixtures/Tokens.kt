package fixtures

import enums.TokenTypes
import org.austral.ingsis.printscript.common.LexicalRange
import org.austral.ingsis.printscript.common.Token

val tokens_001 = listOf(
    Token(type = TokenTypes.LET, from = 0, to = 3, range = LexicalRange(startCol = 0, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.IDENTIFIER, from = 4, to = 5, range = LexicalRange(startCol = 4, startLine = 0, endCol = 5, endLine = 0)),
    Token(type = TokenTypes.COLON, from = 5, to = 6, range = LexicalRange(startCol = 5, startLine = 0, endCol = 6, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 6, to = 7, range = LexicalRange(startCol = 6, startLine = 0, endCol = 7, endLine = 0)),
    Token(type = TokenTypes.TYPESTRING, from = 7, to = 13, range = LexicalRange(startCol = 7, startLine = 0, endCol = 13, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 13, to = 14, range = LexicalRange(startCol = 13, startLine = 0, endCol = 14, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 14, to = 14, range = LexicalRange(startCol = 14, startLine = 0, endCol = 14, endLine = 0))
)

val tokens_002 = listOf(
    Token(type = TokenTypes.IDENTIFIER, from = 0, to = 1, range = LexicalRange(startCol = 0, startLine = 0, endCol = 1, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 1, to = 2, range = LexicalRange(startCol = 1, startLine = 0, endCol = 2, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 2, to = 3, range = LexicalRange(startCol = 2, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.STRING, from = 4, to = 21, range = LexicalRange(startCol = 4, startLine = 0, endCol = 21, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 21, to = 22, range = LexicalRange(startCol = 21, startLine = 0, endCol = 22, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 22, to = 22, range = LexicalRange(startCol = 22, startLine = 0, endCol = 22, endLine = 0))
)

val tokens_003 = listOf(
    Token(type = TokenTypes.IDENTIFIER, from = 0, to = 1, range = LexicalRange(startCol = 0, startLine = 0, endCol = 1, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 1, to = 2, range = LexicalRange(startCol = 1, startLine = 0, endCol = 2, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 2, to = 3, range = LexicalRange(startCol = 2, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.STRING, from = 4, to = 21, range = LexicalRange(startCol = 4, startLine = 0, endCol = 21, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 21, to = 22, range = LexicalRange(startCol = 21, startLine = 0, endCol = 22, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 22, to = 22, range = LexicalRange(startCol = 22, startLine = 0, endCol = 22, endLine = 0))
)

val tokens_004 = listOf(
    Token(type = TokenTypes.LET, from = 0, to = 3, range = LexicalRange(startCol = 0, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.IDENTIFIER, from = 4, to = 5, range = LexicalRange(startCol = 4, startLine = 0, endCol = 5, endLine = 0)),
    Token(type = TokenTypes.COLON, from = 5, to = 6, range = LexicalRange(startCol = 5, startLine = 0, endCol = 6, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 6, to = 7, range = LexicalRange(startCol = 6, startLine = 0, endCol = 7, endLine = 0)),
    Token(type = TokenTypes.TYPESTRING, from = 7, to = 13, range = LexicalRange(startCol = 7, startLine = 0, endCol = 13, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 13, to = 14, range = LexicalRange(startCol = 13, startLine = 0, endCol = 14, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 14, to = 15, range = LexicalRange(startCol = 14, startLine = 0, endCol = 15, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 15, to = 16, range = LexicalRange(startCol = 15, startLine = 0, endCol = 16, endLine = 0)),
    Token(type = TokenTypes.STRING, from = 16, to = 33, range = LexicalRange(startCol = 16, startLine = 0, endCol = 33, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 33, to = 34, range = LexicalRange(startCol = 33, startLine = 0, endCol = 34, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 34, to = 34, range = LexicalRange(startCol = 34, startLine = 0, endCol = 34, endLine = 0))
)

val tokens_005 = listOf(
    Token(type = TokenTypes.LET, from = 0, to = 3, range = LexicalRange(startCol = 0, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.IDENTIFIER, from = 4, to = 5, range = LexicalRange(startCol = 4, startLine = 0, endCol = 5, endLine = 0)),
    Token(type = TokenTypes.COLON, from = 5, to = 6, range = LexicalRange(startCol = 5, startLine = 0, endCol = 6, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 6, to = 7, range = LexicalRange(startCol = 6, startLine = 0, endCol = 7, endLine = 0)),
    Token(type = TokenTypes.TYPENUMBER, from = 7, to = 13, range = LexicalRange(startCol = 7, startLine = 0, endCol = 13, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 13, to = 14, range = LexicalRange(startCol = 13, startLine = 0, endCol = 14, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 14, to = 14, range = LexicalRange(startCol = 14, startLine = 0, endCol = 14, endLine = 0))
)

val tokens_006 = listOf(
    Token(type = TokenTypes.IDENTIFIER, from = 0, to = 1, range = LexicalRange(startCol = 0, startLine = 0, endCol = 1, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 1, to = 2, range = LexicalRange(startCol = 1, startLine = 0, endCol = 2, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 2, to = 3, range = LexicalRange(startCol = 2, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 4, to = 5, range = LexicalRange(startCol = 4, startLine = 0, endCol = 5, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 5, to = 6, range = LexicalRange(startCol = 5, startLine = 0, endCol = 6, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 6, to = 6, range = LexicalRange(startCol = 6, startLine = 0, endCol = 6, endLine = 0))
)

val tokens_007 = listOf(
    Token(type = TokenTypes.LET, from = 0, to = 3, range = LexicalRange(startCol = 0, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.IDENTIFIER, from = 4, to = 5, range = LexicalRange(startCol = 4, startLine = 0, endCol = 5, endLine = 0)),
    Token(type = TokenTypes.COLON, from = 5, to = 6, range = LexicalRange(startCol = 5, startLine = 0, endCol = 6, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 6, to = 7, range = LexicalRange(startCol = 6, startLine = 0, endCol = 7, endLine = 0)),
    Token(type = TokenTypes.TYPENUMBER, from = 7, to = 13, range = LexicalRange(startCol = 7, startLine = 0, endCol = 13, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 13, to = 14, range = LexicalRange(startCol = 13, startLine = 0, endCol = 14, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 14, to = 15, range = LexicalRange(startCol = 14, startLine = 0, endCol = 15, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 15, to = 16, range = LexicalRange(startCol = 15, startLine = 0, endCol = 16, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 16, to = 21, range = LexicalRange(startCol = 16, startLine = 0, endCol = 21, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 21, to = 22, range = LexicalRange(startCol = 21, startLine = 0, endCol = 22, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 22, to = 22, range = LexicalRange(startCol = 22, startLine = 0, endCol = 22, endLine = 0))
)

val tokens_008 = listOf(
    Token(type = TokenTypes.PRINTLN, from = 0, to = 7, range = LexicalRange(startCol = 0, startLine = 0, endCol = 7, endLine = 0)),
    Token(type = TokenTypes.OPENPAREN, from = 7, to = 8, range = LexicalRange(startCol = 7, startLine = 0, endCol = 8, endLine = 0)),
    Token(type = TokenTypes.STRING, from = 8, to = 25, range = LexicalRange(startCol = 8, startLine = 0, endCol = 25, endLine = 0)),
    Token(type = TokenTypes.CLOSEPAREN, from = 25, to = 26, range = LexicalRange(startCol = 25, startLine = 0, endCol = 26, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 26, to = 27, range = LexicalRange(startCol = 26, startLine = 0, endCol = 27, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 27, to = 27, range = LexicalRange(startCol = 27, startLine = 0, endCol = 27, endLine = 0))
)

val tokens_009 = listOf(
    Token(type = TokenTypes.PRINTLN, from = 0, to = 7, range = LexicalRange(startCol = 0, startLine = 0, endCol = 7, endLine = 0)),
    Token(type = TokenTypes.OPENPAREN, from = 7, to = 8, range = LexicalRange(startCol = 7, startLine = 0, endCol = 8, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 8, to = 13, range = LexicalRange(startCol = 8, startLine = 0, endCol = 13, endLine = 0)),
    Token(type = TokenTypes.CLOSEPAREN, from = 13, to = 14, range = LexicalRange(startCol = 13, startLine = 0, endCol = 14, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 14, to = 15, range = LexicalRange(startCol = 14, startLine = 0, endCol = 15, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 15, to = 15, range = LexicalRange(startCol = 15, startLine = 0, endCol = 15, endLine = 0))
)

val tokens_010 = listOf(
    Token(type = TokenTypes.IDENTIFIER, from = 0, to = 1, range = LexicalRange(startCol = 0, startLine = 0, endCol = 1, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 1, to = 2, range = LexicalRange(startCol = 1, startLine = 0, endCol = 2, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 2, to = 3, range = LexicalRange(startCol = 2, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 4, to = 9, range = LexicalRange(startCol = 4, startLine = 0, endCol = 9, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 9, to = 10, range = LexicalRange(startCol = 9, startLine = 0, endCol = 10, endLine = 0)),
    Token(type = TokenTypes.EOL, from = 10, to = 11, range = LexicalRange(startCol = 10, startLine = 0, endCol = 0, endLine = 1)),
    Token(type = TokenTypes.IDENTIFIER, from = 11, to = 12, range = LexicalRange(startCol = 0, startLine = 1, endCol = 1, endLine = 1)),
    Token(type = TokenTypes.WHITESPACE, from = 12, to = 13, range = LexicalRange(startCol = 1, startLine = 1, endCol = 2, endLine = 1)),
    Token(type = TokenTypes.ASSIGNMENT, from = 13, to = 14, range = LexicalRange(startCol = 2, startLine = 1, endCol = 3, endLine = 1)),
    Token(type = TokenTypes.WHITESPACE, from = 14, to = 15, range = LexicalRange(startCol = 3, startLine = 1, endCol = 4, endLine = 1)),
    Token(type = TokenTypes.STRING, from = 15, to = 22, range = LexicalRange(startCol = 4, startLine = 1, endCol = 11, endLine = 1)),
    Token(type = TokenTypes.SEMICOLON, from = 22, to = 23, range = LexicalRange(startCol = 11, startLine = 1, endCol = 12, endLine = 1)),
    Token(type = TokenTypes.EOF, from = 23, to = 23, range = LexicalRange(startCol = 12, startLine = 1, endCol = 12, endLine = 1))
)

val tokens_011 = listOf(
    Token(type = TokenTypes.IDENTIFIER, from = 0, to = 1, range = LexicalRange(startCol = 0, startLine = 0, endCol = 1, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 1, to = 2, range = LexicalRange(startCol = 1, startLine = 0, endCol = 2, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 2, to = 3, range = LexicalRange(startCol = 2, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 4, to = 5, range = LexicalRange(startCol = 4, startLine = 0, endCol = 5, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 5, to = 6, range = LexicalRange(startCol = 5, startLine = 0, endCol = 6, endLine = 0)),
    Token(type = TokenTypes.PLUS, from = 6, to = 7, range = LexicalRange(startCol = 6, startLine = 0, endCol = 7, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 7, to = 8, range = LexicalRange(startCol = 7, startLine = 0, endCol = 8, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 8, to = 9, range = LexicalRange(startCol = 8, startLine = 0, endCol = 9, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 9, to = 10, range = LexicalRange(startCol = 9, startLine = 0, endCol = 10, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 10, to = 10, range = LexicalRange(startCol = 10, startLine = 0, endCol = 10, endLine = 0))
)

val tokens_012 = listOf(
    Token(type = TokenTypes.IDENTIFIER, from = 0, to = 1, range = LexicalRange(startCol = 0, startLine = 0, endCol = 1, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 1, to = 2, range = LexicalRange(startCol = 1, startLine = 0, endCol = 2, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 2, to = 3, range = LexicalRange(startCol = 2, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 4, to = 5, range = LexicalRange(startCol = 4, startLine = 0, endCol = 5, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 5, to = 6, range = LexicalRange(startCol = 5, startLine = 0, endCol = 6, endLine = 0)),
    Token(type = TokenTypes.MINUS, from = 6, to = 7, range = LexicalRange(startCol = 6, startLine = 0, endCol = 7, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 7, to = 8, range = LexicalRange(startCol = 7, startLine = 0, endCol = 8, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 8, to = 9, range = LexicalRange(startCol = 8, startLine = 0, endCol = 9, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 9, to = 10, range = LexicalRange(startCol = 9, startLine = 0, endCol = 10, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 10, to = 10, range = LexicalRange(startCol = 10, startLine = 0, endCol = 10, endLine = 0))
)

val tokens_013 = listOf(
    Token(type = TokenTypes.IDENTIFIER, from = 0, to = 1, range = LexicalRange(startCol = 0, startLine = 0, endCol = 1, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 1, to = 2, range = LexicalRange(startCol = 1, startLine = 0, endCol = 2, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 2, to = 3, range = LexicalRange(startCol = 2, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 4, to = 5, range = LexicalRange(startCol = 4, startLine = 0, endCol = 5, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 5, to = 6, range = LexicalRange(startCol = 5, startLine = 0, endCol = 6, endLine = 0)),
    Token(type = TokenTypes.TIMES, from = 6, to = 7, range = LexicalRange(startCol = 6, startLine = 0, endCol = 7, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 7, to = 8, range = LexicalRange(startCol = 7, startLine = 0, endCol = 8, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 8, to = 9, range = LexicalRange(startCol = 8, startLine = 0, endCol = 9, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 9, to = 10, range = LexicalRange(startCol = 9, startLine = 0, endCol = 10, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 10, to = 10, range = LexicalRange(startCol = 10, startLine = 0, endCol = 10, endLine = 0))
)

val tokens_014 = listOf(
    Token(type = TokenTypes.IDENTIFIER, from = 0, to = 1, range = LexicalRange(startCol = 0, startLine = 0, endCol = 1, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 1, to = 2, range = LexicalRange(startCol = 1, startLine = 0, endCol = 2, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 2, to = 3, range = LexicalRange(startCol = 2, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 4, to = 5, range = LexicalRange(startCol = 4, startLine = 0, endCol = 5, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 5, to = 6, range = LexicalRange(startCol = 5, startLine = 0, endCol = 6, endLine = 0)),
    Token(type = TokenTypes.DIVIDEDBY, from = 6, to = 7, range = LexicalRange(startCol = 6, startLine = 0, endCol = 7, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 7, to = 8, range = LexicalRange(startCol = 7, startLine = 0, endCol = 8, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 8, to = 9, range = LexicalRange(startCol = 8, startLine = 0, endCol = 9, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 9, to = 10, range = LexicalRange(startCol = 9, startLine = 0, endCol = 10, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 10, to = 10, range = LexicalRange(startCol = 10, startLine = 0, endCol = 10, endLine = 0))
)

val tokens_015 = listOf(
    Token(type = TokenTypes.IDENTIFIER, from = 0, to = 1, range = LexicalRange(startCol = 0, startLine = 0, endCol = 1, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 1, to = 2, range = LexicalRange(startCol = 1, startLine = 0, endCol = 2, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 2, to = 3, range = LexicalRange(startCol = 2, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.IDENTIFIER, from = 4, to = 5, range = LexicalRange(startCol = 4, startLine = 0, endCol = 5, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 5, to = 6, range = LexicalRange(startCol = 5, startLine = 0, endCol = 6, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 6, to = 6, range = LexicalRange(startCol = 6, startLine = 0, endCol = 6, endLine = 0))
)

val tokens_016 = listOf(
    Token(type = TokenTypes.IDENTIFIER, from = 0, to = 1, range = LexicalRange(startCol = 0, startLine = 0, endCol = 1, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 1, to = 2, range = LexicalRange(startCol = 1, startLine = 0, endCol = 2, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 2, to = 3, range = LexicalRange(startCol = 2, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.IDENTIFIER, from = 4, to = 5, range = LexicalRange(startCol = 4, startLine = 0, endCol = 5, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 5, to = 6, range = LexicalRange(startCol = 5, startLine = 0, endCol = 6, endLine = 0)),
    Token(type = TokenTypes.PLUS, from = 6, to = 7, range = LexicalRange(startCol = 6, startLine = 0, endCol = 7, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 7, to = 8, range = LexicalRange(startCol = 7, startLine = 0, endCol = 8, endLine = 0)),
    Token(type = TokenTypes.IDENTIFIER, from = 8, to = 9, range = LexicalRange(startCol = 8, startLine = 0, endCol = 9, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 9, to = 10, range = LexicalRange(startCol = 9, startLine = 0, endCol = 10, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 10, to = 10, range = LexicalRange(startCol = 10, startLine = 0, endCol = 10, endLine = 0))
)

val tokens_017 = listOf(
    Token(type = TokenTypes.IDENTIFIER, from = 0, to = 1, range = LexicalRange(startCol = 0, startLine = 0, endCol = 1, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 1, to = 2, range = LexicalRange(startCol = 1, startLine = 0, endCol = 2, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 2, to = 3, range = LexicalRange(startCol = 2, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.OPENPAREN, from = 4, to = 5, range = LexicalRange(startCol = 4, startLine = 0, endCol = 5, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 5, to = 6, range = LexicalRange(startCol = 5, startLine = 0, endCol = 6, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 6, to = 7, range = LexicalRange(startCol = 6, startLine = 0, endCol = 7, endLine = 0)),
    Token(type = TokenTypes.PLUS, from = 7, to = 8, range = LexicalRange(startCol = 7, startLine = 0, endCol = 8, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 8, to = 9, range = LexicalRange(startCol = 8, startLine = 0, endCol = 9, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 9, to = 10, range = LexicalRange(startCol = 9, startLine = 0, endCol = 10, endLine = 0)),
    Token(type = TokenTypes.CLOSEPAREN, from = 10, to = 11, range = LexicalRange(startCol = 10, startLine = 0, endCol = 11, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 11, to = 12, range = LexicalRange(startCol = 11, startLine = 0, endCol = 12, endLine = 0)),
    Token(type = TokenTypes.TIMES, from = 12, to = 13, range = LexicalRange(startCol = 12, startLine = 0, endCol = 13, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 13, to = 14, range = LexicalRange(startCol = 13, startLine = 0, endCol = 14, endLine = 0)),
    Token(type = TokenTypes.IDENTIFIER, from = 14, to = 15, range = LexicalRange(startCol = 14, startLine = 0, endCol = 15, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 15, to = 16, range = LexicalRange(startCol = 15, startLine = 0, endCol = 16, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 16, to = 16, range = LexicalRange(startCol = 16, startLine = 0, endCol = 16, endLine = 0))
)

val tokens_018 = listOf(
    Token(type = TokenTypes.IDENTIFIER, from = 0, to = 1, range = LexicalRange(startCol = 0, startLine = 0, endCol = 1, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 1, to = 2, range = LexicalRange(startCol = 1, startLine = 0, endCol = 2, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 2, to = 3, range = LexicalRange(startCol = 2, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.OPENPAREN, from = 4, to = 5, range = LexicalRange(startCol = 4, startLine = 0, endCol = 5, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 5, to = 6, range = LexicalRange(startCol = 5, startLine = 0, endCol = 6, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 6, to = 7, range = LexicalRange(startCol = 6, startLine = 0, endCol = 7, endLine = 0)),
    Token(type = TokenTypes.PLUS, from = 7, to = 8, range = LexicalRange(startCol = 7, startLine = 0, endCol = 8, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 8, to = 9, range = LexicalRange(startCol = 8, startLine = 0, endCol = 9, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 9, to = 10, range = LexicalRange(startCol = 9, startLine = 0, endCol = 10, endLine = 0)),
    Token(type = TokenTypes.CLOSEPAREN, from = 10, to = 11, range = LexicalRange(startCol = 10, startLine = 0, endCol = 11, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 11, to = 12, range = LexicalRange(startCol = 11, startLine = 0, endCol = 12, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 12, to = 12, range = LexicalRange(startCol = 12, startLine = 0, endCol = 12, endLine = 0))
)

val tokens_019 = listOf(
    Token(type = TokenTypes.IDENTIFIER, from = 0, to = 1, range = LexicalRange(startCol = 0, startLine = 0, endCol = 1, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 1, to = 2, range = LexicalRange(startCol = 1, startLine = 0, endCol = 2, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 2, to = 3, range = LexicalRange(startCol = 2, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.OPENPAREN, from = 4, to = 5, range = LexicalRange(startCol = 4, startLine = 0, endCol = 5, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 5, to = 6, range = LexicalRange(startCol = 5, startLine = 0, endCol = 6, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 6, to = 7, range = LexicalRange(startCol = 6, startLine = 0, endCol = 7, endLine = 0)),
    Token(type = TokenTypes.PLUS, from = 7, to = 8, range = LexicalRange(startCol = 7, startLine = 0, endCol = 8, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 8, to = 9, range = LexicalRange(startCol = 8, startLine = 0, endCol = 9, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 9, to = 10, range = LexicalRange(startCol = 9, startLine = 0, endCol = 10, endLine = 0)),
    Token(type = TokenTypes.CLOSEPAREN, from = 10, to = 11, range = LexicalRange(startCol = 10, startLine = 0, endCol = 11, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 11, to = 12, range = LexicalRange(startCol = 11, startLine = 0, endCol = 12, endLine = 0)),
    Token(type = TokenTypes.TIMES, from = 12, to = 13, range = LexicalRange(startCol = 12, startLine = 0, endCol = 13, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 13, to = 14, range = LexicalRange(startCol = 13, startLine = 0, endCol = 14, endLine = 0)),
    Token(type = TokenTypes.OPENPAREN, from = 14, to = 15, range = LexicalRange(startCol = 14, startLine = 0, endCol = 15, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 15, to = 16, range = LexicalRange(startCol = 15, startLine = 0, endCol = 16, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 16, to = 17, range = LexicalRange(startCol = 16, startLine = 0, endCol = 17, endLine = 0)),
    Token(type = TokenTypes.TIMES, from = 17, to = 18, range = LexicalRange(startCol = 17, startLine = 0, endCol = 18, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 18, to = 19, range = LexicalRange(startCol = 18, startLine = 0, endCol = 19, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 19, to = 20, range = LexicalRange(startCol = 19, startLine = 0, endCol = 20, endLine = 0)),
    Token(type = TokenTypes.CLOSEPAREN, from = 20, to = 21, range = LexicalRange(startCol = 20, startLine = 0, endCol = 21, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 21, to = 22, range = LexicalRange(startCol = 21, startLine = 0, endCol = 22, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 22, to = 22, range = LexicalRange(startCol = 22, startLine = 0, endCol = 22, endLine = 0))

)

val tokens_020 = listOf(
    Token(type = TokenTypes.IDENTIFIER, from = 0, to = 1, range = LexicalRange(startCol = 0, startLine = 0, endCol = 1, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 1, to = 2, range = LexicalRange(startCol = 1, startLine = 0, endCol = 2, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 2, to = 3, range = LexicalRange(startCol = 2, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.IDENTIFIER, from = 4, to = 5, range = LexicalRange(startCol = 4, startLine = 0, endCol = 5, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 5, to = 6, range = LexicalRange(startCol = 5, startLine = 0, endCol = 6, endLine = 0)),
    Token(type = TokenTypes.MINUS, from = 6, to = 7, range = LexicalRange(startCol = 6, startLine = 0, endCol = 7, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 7, to = 8, range = LexicalRange(startCol = 7, startLine = 0, endCol = 8, endLine = 0)),
    Token(type = TokenTypes.OPENPAREN, from = 8, to = 9, range = LexicalRange(startCol = 8, startLine = 0, endCol = 9, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 9, to = 10, range = LexicalRange(startCol = 9, startLine = 0, endCol = 10, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 10, to = 11, range = LexicalRange(startCol = 10, startLine = 0, endCol = 11, endLine = 0)),
    Token(type = TokenTypes.DIVIDEDBY, from = 11, to = 12, range = LexicalRange(startCol = 11, startLine = 0, endCol = 12, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 12, to = 13, range = LexicalRange(startCol = 12, startLine = 0, endCol = 13, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 13, to = 14, range = LexicalRange(startCol = 13, startLine = 0, endCol = 14, endLine = 0)),
    Token(type = TokenTypes.CLOSEPAREN, from = 14, to = 15, range = LexicalRange(startCol = 14, startLine = 0, endCol = 15, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 15, to = 16, range = LexicalRange(startCol = 15, startLine = 0, endCol = 16, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 16, to = 16, range = LexicalRange(startCol = 16, startLine = 0, endCol = 16, endLine = 0))
)

val tokens_021 = listOf(
    Token(type = TokenTypes.IDENTIFIER, from = 0, to = 1, range = LexicalRange(startCol = 0, startLine = 0, endCol = 1, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 1, to = 2, range = LexicalRange(startCol = 1, startLine = 0, endCol = 2, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 2, to = 3, range = LexicalRange(startCol = 2, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 4, to = 5, range = LexicalRange(startCol = 4, startLine = 0, endCol = 5, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 5, to = 6, range = LexicalRange(startCol = 5, startLine = 0, endCol = 6, endLine = 0)),
    Token(type = TokenTypes.PLUS, from = 6, to = 7, range = LexicalRange(startCol = 6, startLine = 0, endCol = 7, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 7, to = 8, range = LexicalRange(startCol = 7, startLine = 0, endCol = 8, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 8, to = 9, range = LexicalRange(startCol = 8, startLine = 0, endCol = 9, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 9, to = 10, range = LexicalRange(startCol = 9, startLine = 0, endCol = 10, endLine = 0)),
    Token(type = TokenTypes.TIMES, from = 10, to = 11, range = LexicalRange(startCol = 10, startLine = 0, endCol = 11, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 11, to = 12, range = LexicalRange(startCol = 11, startLine = 0, endCol = 12, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 12, to = 13, range = LexicalRange(startCol = 12, startLine = 0, endCol = 13, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 13, to = 14, range = LexicalRange(startCol = 13, startLine = 0, endCol = 14, endLine = 0)),
    Token(type = TokenTypes.MINUS, from = 14, to = 15, range = LexicalRange(startCol = 14, startLine = 0, endCol = 15, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 15, to = 16, range = LexicalRange(startCol = 15, startLine = 0, endCol = 16, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 16, to = 17, range = LexicalRange(startCol = 16, startLine = 0, endCol = 17, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 17, to = 18, range = LexicalRange(startCol = 17, startLine = 0, endCol = 18, endLine = 0)),
    Token(type = TokenTypes.DIVIDEDBY, from = 18, to = 19, range = LexicalRange(startCol = 18, startLine = 0, endCol = 19, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 19, to = 20, range = LexicalRange(startCol = 19, startLine = 0, endCol = 20, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 20, to = 21, range = LexicalRange(startCol = 20, startLine = 0, endCol = 21, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 21, to = 22, range = LexicalRange(startCol = 21, startLine = 0, endCol = 22, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 22, to = 22, range = LexicalRange(startCol = 22, startLine = 0, endCol = 22, endLine = 0))
)

val tokens_022 = listOf(
    Token(type = TokenTypes.IDENTIFIER, from = 0, to = 1, range = LexicalRange(startCol = 0, startLine = 0, endCol = 1, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 1, to = 2, range = LexicalRange(startCol = 1, startLine = 0, endCol = 2, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 2, to = 3, range = LexicalRange(startCol = 2, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 4, to = 5, range = LexicalRange(startCol = 4, startLine = 0, endCol = 5, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 5, to = 6, range = LexicalRange(startCol = 5, startLine = 0, endCol = 6, endLine = 0)),
    Token(type = TokenTypes.TIMES, from = 6, to = 7, range = LexicalRange(startCol = 6, startLine = 0, endCol = 7, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 7, to = 8, range = LexicalRange(startCol = 7, startLine = 0, endCol = 8, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 8, to = 9, range = LexicalRange(startCol = 8, startLine = 0, endCol = 9, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 9, to = 10, range = LexicalRange(startCol = 9, startLine = 0, endCol = 10, endLine = 0)),
    Token(type = TokenTypes.MINUS, from = 10, to = 11, range = LexicalRange(startCol = 10, startLine = 0, endCol = 11, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 11, to = 12, range = LexicalRange(startCol = 11, startLine = 0, endCol = 12, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 12, to = 13, range = LexicalRange(startCol = 12, startLine = 0, endCol = 13, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 13, to = 14, range = LexicalRange(startCol = 13, startLine = 0, endCol = 14, endLine = 0)),
    Token(type = TokenTypes.DIVIDEDBY, from = 14, to = 15, range = LexicalRange(startCol = 14, startLine = 0, endCol = 15, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 15, to = 16, range = LexicalRange(startCol = 15, startLine = 0, endCol = 16, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 16, to = 17, range = LexicalRange(startCol = 16, startLine = 0, endCol = 17, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 17, to = 18, range = LexicalRange(startCol = 17, startLine = 0, endCol = 18, endLine = 0)),
    Token(type = TokenTypes.PLUS, from = 18, to = 19, range = LexicalRange(startCol = 18, startLine = 0, endCol = 19, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 19, to = 20, range = LexicalRange(startCol = 19, startLine = 0, endCol = 20, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 20, to = 21, range = LexicalRange(startCol = 20, startLine = 0, endCol = 21, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 21, to = 22, range = LexicalRange(startCol = 21, startLine = 0, endCol = 22, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 22, to = 22, range = LexicalRange(startCol = 22, startLine = 0, endCol = 22, endLine = 0))
)

val tokens_023 = listOf(
    Token(type = TokenTypes.PRINTLN, from = 0, to = 7, range = LexicalRange(startCol = 0, startLine = 0, endCol = 7, endLine = 0)),
    Token(type = TokenTypes.OPENPAREN, from = 7, to = 8, range = LexicalRange(startCol = 7, startLine = 0, endCol = 8, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 8, to = 9, range = LexicalRange(startCol = 8, startLine = 0, endCol = 9, endLine = 0)),
    Token(type = TokenTypes.CLOSEPAREN, from = 9, to = 10, range = LexicalRange(startCol = 9, startLine = 0, endCol = 10, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 10, to = 10, range = LexicalRange(startCol = 10, startLine = 0, endCol = 10, endLine = 0))
)

val tokens_024 = listOf(
    Token(type = TokenTypes.IDENTIFIER, from = 0, to = 1, range = LexicalRange(startCol = 0, startLine = 0, endCol = 1, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 1, to = 2, range = LexicalRange(startCol = 1, startLine = 0, endCol = 2, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 2, to = 3, range = LexicalRange(startCol = 2, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.STRING, from = 4, to = 31, range = LexicalRange(startCol = 4, startLine = 0, endCol = 31, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 31, to = 32, range = LexicalRange(startCol = 31, startLine = 0, endCol = 32, endLine = 0)),
    Token(type = TokenTypes.PLUS, from = 32, to = 33, range = LexicalRange(startCol = 32, startLine = 0, endCol = 33, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 33, to = 34, range = LexicalRange(startCol = 33, startLine = 0, endCol = 34, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 34, to = 36, range = LexicalRange(startCol = 34, startLine = 0, endCol = 36, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 36, to = 37, range = LexicalRange(startCol = 36, startLine = 0, endCol = 37, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 37, to = 37, range = LexicalRange(startCol = 37, startLine = 0, endCol = 37, endLine = 0))
)

val tokens_025 = listOf(
    Token(type = TokenTypes.CONST, from = 0, to = 5, range = LexicalRange(startCol = 0, startLine = 0, endCol = 5, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 5, to = 6, range = LexicalRange(startCol = 5, startLine = 0, endCol = 6, endLine = 0)),
    Token(type = TokenTypes.IDENTIFIER, from = 6, to = 7, range = LexicalRange(startCol = 6, startLine = 0, endCol = 7, endLine = 0)),
    Token(type = TokenTypes.COLON, from = 7, to = 8, range = LexicalRange(startCol = 7, startLine = 0, endCol = 8, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 8, to = 9, range = LexicalRange(startCol = 8, startLine = 0, endCol = 9, endLine = 0)),
    Token(type = TokenTypes.TYPENUMBER, from = 9, to = 15, range = LexicalRange(startCol = 9, startLine = 0, endCol = 15, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 15, to = 16, range = LexicalRange(startCol = 15, startLine = 0, endCol = 16, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 16, to = 17, range = LexicalRange(startCol = 16, startLine = 0, endCol = 17, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 17, to = 18, range = LexicalRange(startCol = 17, startLine = 0, endCol = 18, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 18, to = 20, range = LexicalRange(startCol = 18, startLine = 0, endCol = 20, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 20, to = 21, range = LexicalRange(startCol = 20, startLine = 0, endCol = 21, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 21, to = 21, range = LexicalRange(startCol = 21, startLine = 0, endCol = 21, endLine = 0))
)

val tokens_026 = listOf(
    Token(type = TokenTypes.LET, from = 0, to = 3, range = LexicalRange(startCol = 0, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.IDENTIFIER, from = 4, to = 5, range = LexicalRange(startCol = 4, startLine = 0, endCol = 5, endLine = 0)),
    Token(type = TokenTypes.COLON, from = 5, to = 6, range = LexicalRange(startCol = 5, startLine = 0, endCol = 6, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 6, to = 7, range = LexicalRange(startCol = 6, startLine = 0, endCol = 7, endLine = 0)),
    Token(type = TokenTypes.TYPEBOOLEAN, from = 7, to = 14, range = LexicalRange(startCol = 7, startLine = 0, endCol = 14, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 14, to = 15, range = LexicalRange(startCol = 14, startLine = 0, endCol = 15, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 15, to = 16, range = LexicalRange(startCol = 15, startLine = 0, endCol = 16, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 16, to = 17, range = LexicalRange(startCol = 16, startLine = 0, endCol = 17, endLine = 0)),
    Token(type = TokenTypes.BOOLEAN, from = 17, to = 21, range = LexicalRange(startCol = 17, startLine = 0, endCol = 21, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 21, to = 22, range = LexicalRange(startCol = 21, startLine = 0, endCol = 22, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 22, to = 22, range = LexicalRange(startCol = 22, startLine = 0, endCol = 22, endLine = 0))
)

val tokens_027 = listOf(
    Token(type = TokenTypes.IF, from = 0, to = 2, range = LexicalRange(startCol = 0, startLine = 0, endCol = 2, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 2, to = 3, range = LexicalRange(startCol = 2, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.OPENPAREN, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.BOOLEAN, from = 4, to = 8, range = LexicalRange(startCol = 4, startLine = 0, endCol = 8, endLine = 0)),
    Token(type = TokenTypes.CLOSEPAREN, from = 8, to = 9, range = LexicalRange(startCol = 8, startLine = 0, endCol = 9, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 9, to = 10, range = LexicalRange(startCol = 9, startLine = 0, endCol = 10, endLine = 0)),
    Token(type = TokenTypes.OPENBRACE, from = 10, to = 11, range = LexicalRange(startCol = 10, startLine = 0, endCol = 11, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 11, to = 12, range = LexicalRange(startCol = 11, startLine = 0, endCol = 12, endLine = 0)),
    Token(type = TokenTypes.PRINTLN, from = 12, to = 19, range = LexicalRange(startCol = 12, startLine = 0, endCol = 19, endLine = 0)),
    Token(type = TokenTypes.OPENPAREN, from = 19, to = 20, range = LexicalRange(startCol = 19, startLine = 0, endCol = 20, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 20, to = 22, range = LexicalRange(startCol = 20, startLine = 0, endCol = 22, endLine = 0)),
    Token(type = TokenTypes.CLOSEPAREN, from = 22, to = 23, range = LexicalRange(startCol = 22, startLine = 0, endCol = 23, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 23, to = 24, range = LexicalRange(startCol = 23, startLine = 0, endCol = 24, endLine = 0)),
    Token(type = TokenTypes.CLOSEBRACE, from = 24, to = 25, range = LexicalRange(startCol = 24, startLine = 0, endCol = 25, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 25, to = 26, range = LexicalRange(startCol = 25, startLine = 0, endCol = 26, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 26, to = 26, range = LexicalRange(startCol = 26, startLine = 0, endCol = 26, endLine = 0))
)

val tokens_028 = listOf(
    Token(type = TokenTypes.IF, from = 0, to = 2, range = LexicalRange(startCol = 0, startLine = 0, endCol = 2, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 2, to = 3, range = LexicalRange(startCol = 2, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.OPENPAREN, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.BOOLEAN, from = 4, to = 8, range = LexicalRange(startCol = 4, startLine = 0, endCol = 8, endLine = 0)),
    Token(type = TokenTypes.CLOSEPAREN, from = 8, to = 9, range = LexicalRange(startCol = 8, startLine = 0, endCol = 9, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 9, to = 10, range = LexicalRange(startCol = 9, startLine = 0, endCol = 10, endLine = 0)),
    Token(type = TokenTypes.OPENBRACE, from = 10, to = 11, range = LexicalRange(startCol = 10, startLine = 0, endCol = 11, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 11, to = 12, range = LexicalRange(startCol = 11, startLine = 0, endCol = 12, endLine = 0)),
    Token(type = TokenTypes.EOL, from = 12, to = 13, range = LexicalRange(startCol = 12, startLine = 0, endCol = 0, endLine = 1)),
    Token(type = TokenTypes.WHITESPACE, from = 13, to = 14, range = LexicalRange(startCol = 0, startLine = 1, endCol = 1, endLine = 1)),
    Token(type = TokenTypes.PRINTLN, from = 14, to = 21, range = LexicalRange(startCol = 1, startLine = 1, endCol = 8, endLine = 1)),
    Token(type = TokenTypes.OPENPAREN, from = 21, to = 22, range = LexicalRange(startCol = 8, startLine = 1, endCol = 9, endLine = 1)),
    Token(type = TokenTypes.NUMBER, from = 22, to = 24, range = LexicalRange(startCol = 9, startLine = 1, endCol = 11, endLine = 1)),
    Token(type = TokenTypes.CLOSEPAREN, from = 24, to = 25, range = LexicalRange(startCol = 11, startLine = 1, endCol = 12, endLine = 1)),
    Token(type = TokenTypes.SEMICOLON, from = 25, to = 26, range = LexicalRange(startCol = 12, startLine = 1, endCol = 13, endLine = 1)),
    Token(type = TokenTypes.WHITESPACE, from = 26, to = 27, range = LexicalRange(startCol = 13, startLine = 1, endCol = 14, endLine = 1)),
    Token(type = TokenTypes.EOL, from = 27, to = 28, range = LexicalRange(startCol = 14, startLine = 1, endCol = 0, endLine = 2)),
    Token(type = TokenTypes.WHITESPACE, from = 28, to = 29, range = LexicalRange(startCol = 0, startLine = 2, endCol = 1, endLine = 2)),
    Token(type = TokenTypes.CLOSEBRACE, from = 29, to = 30, range = LexicalRange(startCol = 1, startLine = 2, endCol = 2, endLine = 2)),
    Token(type = TokenTypes.SEMICOLON, from = 30, to = 31, range = LexicalRange(startCol = 2, startLine = 2, endCol = 3, endLine = 2)),
    Token(type = TokenTypes.EOF, from = 31, to = 31, range = LexicalRange(startCol = 3, startLine = 2, endCol = 3, endLine = 2))
)

val tokens_029 = listOf(
    Token(type = TokenTypes.IF, from = 0, to = 2, range = LexicalRange(startCol = 0, startLine = 0, endCol = 2, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 2, to = 3, range = LexicalRange(startCol = 2, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.OPENPAREN, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.BOOLEAN, from = 4, to = 8, range = LexicalRange(startCol = 4, startLine = 0, endCol = 8, endLine = 0)),
    Token(type = TokenTypes.CLOSEPAREN, from = 8, to = 9, range = LexicalRange(startCol = 8, startLine = 0, endCol = 9, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 9, to = 10, range = LexicalRange(startCol = 9, startLine = 0, endCol = 10, endLine = 0)),
    Token(type = TokenTypes.OPENBRACE, from = 10, to = 11, range = LexicalRange(startCol = 10, startLine = 0, endCol = 11, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 11, to = 12, range = LexicalRange(startCol = 11, startLine = 0, endCol = 12, endLine = 0)),
    Token(type = TokenTypes.EOL, from = 12, to = 13, range = LexicalRange(startCol = 12, startLine = 0, endCol = 0, endLine = 1)),
    Token(type = TokenTypes.WHITESPACE, from = 13, to = 14, range = LexicalRange(startCol = 0, startLine = 1, endCol = 1, endLine = 1)),
    Token(type = TokenTypes.PRINTLN, from = 14, to = 21, range = LexicalRange(startCol = 1, startLine = 1, endCol = 8, endLine = 1)),
    Token(type = TokenTypes.OPENPAREN, from = 21, to = 22, range = LexicalRange(startCol = 8, startLine = 1, endCol = 9, endLine = 1)),
    Token(type = TokenTypes.NUMBER, from = 22, to = 24, range = LexicalRange(startCol = 9, startLine = 1, endCol = 11, endLine = 1)),
    Token(type = TokenTypes.CLOSEPAREN, from = 24, to = 25, range = LexicalRange(startCol = 11, startLine = 1, endCol = 12, endLine = 1)),
    Token(type = TokenTypes.SEMICOLON, from = 25, to = 26, range = LexicalRange(startCol = 12, startLine = 1, endCol = 13, endLine = 1)),
    Token(type = TokenTypes.WHITESPACE, from = 26, to = 27, range = LexicalRange(startCol = 13, startLine = 1, endCol = 14, endLine = 1)),
    Token(type = TokenTypes.EOL, from = 27, to = 28, range = LexicalRange(startCol = 14, startLine = 1, endCol = 0, endLine = 2)),
    Token(type = TokenTypes.WHITESPACE, from = 28, to = 29, range = LexicalRange(startCol = 0, startLine = 2, endCol = 1, endLine = 2)),
    Token(type = TokenTypes.PRINTLN, from = 29, to = 36, range = LexicalRange(startCol = 1, startLine = 2, endCol = 8, endLine = 2)),
    Token(type = TokenTypes.OPENPAREN, from = 36, to = 37, range = LexicalRange(startCol = 8, startLine = 2, endCol = 9, endLine = 2)),
    Token(type = TokenTypes.STRING, from = 37, to = 44, range = LexicalRange(startCol = 9, startLine = 2, endCol = 16, endLine = 2)),
    Token(type = TokenTypes.CLOSEPAREN, from = 44, to = 45, range = LexicalRange(startCol = 16, startLine = 2, endCol = 17, endLine = 2)),
    Token(type = TokenTypes.SEMICOLON, from = 45, to = 46, range = LexicalRange(startCol = 17, startLine = 2, endCol = 18, endLine = 2)),
    Token(type = TokenTypes.WHITESPACE, from = 46, to = 47, range = LexicalRange(startCol = 18, startLine = 2, endCol = 19, endLine = 2)),
    Token(type = TokenTypes.EOL, from = 47, to = 48, range = LexicalRange(startCol = 19, startLine = 2, endCol = 0, endLine = 3)),
    Token(type = TokenTypes.WHITESPACE, from = 48, to = 49, range = LexicalRange(startCol = 0, startLine = 3, endCol = 1, endLine = 3)),
    Token(type = TokenTypes.CLOSEBRACE, from = 49, to = 50, range = LexicalRange(startCol = 1, startLine = 3, endCol = 2, endLine = 3)),
    Token(type = TokenTypes.SEMICOLON, from = 50, to = 51, range = LexicalRange(startCol = 2, startLine = 3, endCol = 3, endLine = 3)),
    Token(type = TokenTypes.EOF, from = 51, to = 51, range = LexicalRange(startCol = 3, startLine = 3, endCol = 3, endLine = 3))
)

val tokens_030 = listOf(
    Token(type = TokenTypes.IF, from = 0, to = 2, range = LexicalRange(startCol = 0, startLine = 0, endCol = 2, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 2, to = 3, range = LexicalRange(startCol = 2, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.OPENPAREN, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.BOOLEAN, from = 4, to = 9, range = LexicalRange(startCol = 4, startLine = 0, endCol = 9, endLine = 0)),
    Token(type = TokenTypes.CLOSEPAREN, from = 9, to = 10, range = LexicalRange(startCol = 9, startLine = 0, endCol = 10, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 10, to = 11, range = LexicalRange(startCol = 10, startLine = 0, endCol = 11, endLine = 0)),
    Token(type = TokenTypes.OPENBRACE, from = 11, to = 12, range = LexicalRange(startCol = 11, startLine = 0, endCol = 12, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 12, to = 13, range = LexicalRange(startCol = 12, startLine = 0, endCol = 13, endLine = 0)),
    Token(type = TokenTypes.PRINTLN, from = 13, to = 20, range = LexicalRange(startCol = 13, startLine = 0, endCol = 20, endLine = 0)),
    Token(type = TokenTypes.OPENPAREN, from = 20, to = 21, range = LexicalRange(startCol = 20, startLine = 0, endCol = 21, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 21, to = 23, range = LexicalRange(startCol = 21, startLine = 0, endCol = 23, endLine = 0)),
    Token(type = TokenTypes.CLOSEPAREN, from = 23, to = 24, range = LexicalRange(startCol = 23, startLine = 0, endCol = 24, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 24, to = 25, range = LexicalRange(startCol = 24, startLine = 0, endCol = 25, endLine = 0)),
    Token(type = TokenTypes.CLOSEBRACE, from = 25, to = 26, range = LexicalRange(startCol = 25, startLine = 0, endCol = 26, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 26, to = 27, range = LexicalRange(startCol = 26, startLine = 0, endCol = 27, endLine = 0)),
    Token(type = TokenTypes.ELSE, from = 27, to = 31, range = LexicalRange(startCol = 27, startLine = 0, endCol = 31, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 31, to = 32, range = LexicalRange(startCol = 31, startLine = 0, endCol = 32, endLine = 0)),
    Token(type = TokenTypes.OPENBRACE, from = 32, to = 33, range = LexicalRange(startCol = 32, startLine = 0, endCol = 33, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 33, to = 34, range = LexicalRange(startCol = 33, startLine = 0, endCol = 34, endLine = 0)),
    Token(type = TokenTypes.PRINTLN, from = 34, to = 41, range = LexicalRange(startCol = 34, startLine = 0, endCol = 41, endLine = 0)),
    Token(type = TokenTypes.OPENPAREN, from = 41, to = 42, range = LexicalRange(startCol = 41, startLine = 0, endCol = 42, endLine = 0)),
    Token(type = TokenTypes.NUMBER, from = 42, to = 44, range = LexicalRange(startCol = 42, startLine = 0, endCol = 44, endLine = 0)),
    Token(type = TokenTypes.CLOSEPAREN, from = 44, to = 45, range = LexicalRange(startCol = 44, startLine = 0, endCol = 45, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 45, to = 46, range = LexicalRange(startCol = 45, startLine = 0, endCol = 46, endLine = 0)),
    Token(type = TokenTypes.CLOSEBRACE, from = 46, to = 47, range = LexicalRange(startCol = 46, startLine = 0, endCol = 47, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 47, to = 48, range = LexicalRange(startCol = 47, startLine = 0, endCol = 48, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 48, to = 48, range = LexicalRange(startCol = 48, startLine = 0, endCol = 48, endLine = 0))
)

val tokens_031 = listOf(
    Token(type = TokenTypes.LET, from = 0, to = 3, range = LexicalRange(startCol = 0, startLine = 0, endCol = 3, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 3, to = 4, range = LexicalRange(startCol = 3, startLine = 0, endCol = 4, endLine = 0)),
    Token(type = TokenTypes.IDENTIFIER, from = 4, to = 5, range = LexicalRange(startCol = 4, startLine = 0, endCol = 5, endLine = 0)),
    Token(type = TokenTypes.COLON, from = 5, to = 6, range = LexicalRange(startCol = 5, startLine = 0, endCol = 6, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 6, to = 7, range = LexicalRange(startCol = 6, startLine = 0, endCol = 7, endLine = 0)),
    Token(type = TokenTypes.TYPESTRING, from = 7, to = 13, range = LexicalRange(startCol = 7, startLine = 0, endCol = 13, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 13, to = 14, range = LexicalRange(startCol = 13, startLine = 0, endCol = 14, endLine = 0)),
    Token(type = TokenTypes.ASSIGNMENT, from = 14, to = 15, range = LexicalRange(startCol = 14, startLine = 0, endCol = 15, endLine = 0)),
    Token(type = TokenTypes.WHITESPACE, from = 15, to = 16, range = LexicalRange(startCol = 15, startLine = 0, endCol = 16, endLine = 0)),
    Token(type = TokenTypes.READINPUT, from = 16, to = 25, range = LexicalRange(startCol = 16, startLine = 0, endCol = 25, endLine = 0)),
    Token(type = TokenTypes.OPENPAREN, from = 25, to = 26, range = LexicalRange(startCol = 25, startLine = 0, endCol = 26, endLine = 0)),
    Token(type = TokenTypes.STRING, from = 26, to = 42, range = LexicalRange(startCol = 26, startLine = 0, endCol = 42, endLine = 0)),
    Token(type = TokenTypes.CLOSEPAREN, from = 42, to = 43, range = LexicalRange(startCol = 42, startLine = 0, endCol = 43, endLine = 0)),
    Token(type = TokenTypes.SEMICOLON, from = 43, to = 44, range = LexicalRange(startCol = 43, startLine = 0, endCol = 44, endLine = 0)),
    Token(type = TokenTypes.EOF, from = 44, to = 44, range = LexicalRange(startCol = 44, startLine = 0, endCol = 44, endLine = 0))
)
