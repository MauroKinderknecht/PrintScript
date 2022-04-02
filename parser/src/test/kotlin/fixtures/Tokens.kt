package fixtures

import impl.enums.TokenTypes
import org.austral.ingsis.printscript.common.LexicalRange
import org.austral.ingsis.printscript.common.Token

val tokens_001 = listOf(
    Token(type= TokenTypes.LET, from=0, to=3, range= LexicalRange(startCol=0, startLine=0, endCol=3, endLine=0)),
    Token(type= TokenTypes.WHITESPACE, from=3, to=4, range= LexicalRange(startCol=3, startLine=0, endCol=4, endLine=0)),
    Token(type= TokenTypes.TYPESTRING, from=4, to=5, range= LexicalRange(startCol=4, startLine=0, endCol=5, endLine=0)),
    Token(type= TokenTypes.COLON, from=5, to=6, range= LexicalRange(startCol=5, startLine=0, endCol=6, endLine=0)),
    Token(type= TokenTypes.WHITESPACE, from=6, to=7, range= LexicalRange(startCol=6, startLine=0, endCol=7, endLine=0)),
    Token(type= TokenTypes.IDENTIFIER, from=7, to=13, range= LexicalRange(startCol=7, startLine=0, endCol=13, endLine=0)),
    Token(type= TokenTypes.SEMICOLON, from=13, to=14, range= LexicalRange(startCol=13, startLine=0, endCol=14, endLine=0)),
    Token(type= TokenTypes.EOF, from=14, to=14, range= LexicalRange(startCol=14, startLine=0, endCol=14, endLine=0))
)