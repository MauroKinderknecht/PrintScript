import exception.LexerException
import fixtures.*
import impl.LexerImpl
import impl.enums.TokenTypes
import interfaces.Lexer
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class LexerTest {

    private val lexer: Lexer = LexerImpl(  )

    // Valid syntaxes tests

    @Test
    fun test001_stringDeclarationTest() {
        val tokens = lexer.lex(src_001)
        val expected = tokens_001.toString()

        assertEquals(8, tokens.size)
        assertEquals(expected, tokens.toString())
    }

    @Test
    fun test002_stringDoubleQuoteAssignationTest() {
        val tokens = lexer.lex(src_002)
        val expected = tokens_002.toString()

        assertEquals(7, tokens.size)
        assertEquals(expected, tokens.toString())
    }

    @Test
    fun test003_stringSingleQuoteAssignationTest() {
        val tokens = lexer.lex(src_003)
        val expected = tokens_003.toString()

        assertEquals(7, tokens.size)
        assertEquals(expected, tokens.toString())
    }

    @Test
    fun test004_stringDeclarationAssignationTest() {
        val tokens = lexer.lex(src_004)
        val expected = tokens_004.toString()

        assertEquals(12, tokens.size)
        assertEquals(expected, tokens.toString())
    }

    @Test
    fun test005_numberDeclarationTest() {
        val tokens = lexer.lex(src_005)
        val expected = tokens_005.toString()

        assertEquals(8, tokens.size)
        assertEquals(expected, tokens.toString())
    }

    @Test
    fun test006_numberIntegerAssignationTest() {
        val tokens = lexer.lex(src_006)
        val expected = tokens_006.toString()

        assertEquals(7, tokens.size)
        assertEquals(expected, tokens.toString())
    }

    @Test
    fun test007_numberDeclarationAssignationTest() {
        val tokens = lexer.lex(src_007)
        val expected = tokens_007.toString()

        assertEquals(12, tokens.size)
        assertEquals(expected, tokens.toString())
    }

    @Test
    fun test008_printStringTest() {
        val tokens = lexer.lex(src_008)
        val expected = tokens_008.toString()

        assertEquals(6, tokens.size)
        assertEquals(expected, tokens.toString())
    }

    @Test
    fun test009_printNumberTest() {
        val tokens = lexer.lex(src_009)
        val expected = tokens_009.toString()

        assertEquals(6, tokens.size)
        assertEquals(expected, tokens.toString())
    }

    @Test
    fun test010_newLineTest() {
        val tokens = lexer.lex(src_010)
        val expected = tokens_010.toString()

        assertEquals(14, tokens.size)
        assertEquals(expected, tokens.toString())
    }

    @Test
    fun test011_additionTest() {
        val tokens = lexer.lex(src_011)
        val expected = tokens_011.toString()

        assertEquals(11, tokens.size)
        assertEquals(expected, tokens.toString())
    }

    @Test
    fun test012_subtractionTest() {
        val tokens = lexer.lex(src_012)
        val expected = tokens_012.toString()

        assertEquals(11, tokens.size)
        assertEquals(expected, tokens.toString())
    }

    @Test
    fun test013_multiplicationTest() {
        val tokens = lexer.lex(src_013)
        val expected = tokens_013.toString()

        assertEquals(11, tokens.size)
        assertEquals(expected, tokens.toString())
    }

    @Test
    fun test014_divisionTest() {
        val tokens = lexer.lex(src_014)
        val expected = tokens_014.toString()

        assertEquals(11, tokens.size)
        assertEquals(expected, tokens.toString())
    }

    // Token Regex Test

    @Test
    fun test015_letTokenTest() {
        val tokens = lexer.lex(src_015)
        val expected = TokenTypes.LET

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test016_typeStringTokenTest() {
        val tokens = lexer.lex(src_016)
        val expected = TokenTypes.TYPESTRING

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test017_typeNumberTokenTest() {
        val tokens = lexer.lex(src_017)
        val expected = TokenTypes.TYPENUMBER

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test018_printlnTokenTest() {
        val tokens = lexer.lex(src_018)
        val expected = TokenTypes.PRINTLN

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test019_plusTokenTest() {
        val tokens = lexer.lex(src_019)
        val expected = TokenTypes.PLUS

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test020_minusTokenTest() {
        val tokens = lexer.lex(src_020)
        val expected = TokenTypes.MINUS

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test021_timesTokenTest() {
        val tokens = lexer.lex(src_021)
        val expected = TokenTypes.TIMES

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test022_dividedByTokenTest() {
        val tokens = lexer.lex(src_022)
        val expected = TokenTypes.DIVIDEDBY

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test023_assignmentTokenTest() {
        val tokens = lexer.lex(src_023)
        val expected = TokenTypes.ASSIGNMENT

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test024_openParenTokenTest() {
        val tokens = lexer.lex(src_024)
        val expected = TokenTypes.OPENPAREN

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test025_closeParenTokenTest() {
        val tokens = lexer.lex(src_025)
        val expected = TokenTypes.CLOSEPAREN

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test026_numberTokenTest() {
        val tokens = lexer.lex(src_026)
        val expected = TokenTypes.NUMBER

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test027_numberTokenTest() {
        val tokens = lexer.lex(src_027)
        val expected = TokenTypes.NUMBER

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test028_numberTokenTest() {
        val tokens = lexer.lex(src_028)
        val expected = TokenTypes.NUMBER

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test029_numberTokenTest() {
        val tokens = lexer.lex(src_029)
        val expected = TokenTypes.NUMBER

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test030_numberTokenTest() {
        val tokens = lexer.lex(src_030)
        val expected = TokenTypes.NUMBER

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test031_stringTokenTest() {
        val tokens = lexer.lex(src_031)
        val expected = TokenTypes.STRING

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test032_stringTokenTest() {
        val tokens = lexer.lex(src_032)
        val expected = TokenTypes.STRING

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test033_stringTokenTest() {
        val tokens = lexer.lex(src_033)
        val expected = TokenTypes.STRING

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test034_stringTokenTest() {
        val tokens = lexer.lex(src_034)
        val expected = TokenTypes.STRING

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test035_identifierTokenTest() {
        val tokens = lexer.lex(src_035)
        val expected = TokenTypes.IDENTIFIER

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test036_identifierTokenTest() {
        val tokens = lexer.lex(src_036)
        val expected = TokenTypes.IDENTIFIER

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test037_identifierTokenTest() {
        val tokens = lexer.lex(src_037)
        val expected = TokenTypes.IDENTIFIER

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test038_identifierTokenTest() {
        val tokens = lexer.lex(src_038)
        val expected = TokenTypes.IDENTIFIER

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test039_identifierTokenTest() {
        val tokens = lexer.lex(src_039)
        val expected = TokenTypes.IDENTIFIER

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test040_identifierTokenTest() {
        val tokens = lexer.lex(src_040)
        val expected = TokenTypes.IDENTIFIER

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test041_whitespaceTokenTest() {
        val tokens = lexer.lex(src_041)
        val expected = TokenTypes.WHITESPACE

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test042_eofTokenTest() {
        val tokens = lexer.lex(src_042)
        val expected = TokenTypes.EOF

        assertEquals(1, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test043_eolTokenTest() {
        val tokens = lexer.lex(src_043)
        val expected = TokenTypes.EOL

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test044_colonTokenTest() {
        val tokens = lexer.lex(src_044)
        val expected = TokenTypes.COLON

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    @Test
    fun test045_semicolonTokenTest() {
        val tokens = lexer.lex(src_045)
        val expected = TokenTypes.SEMICOLON

        assertEquals(2, tokens.size)
        assertEquals(expected, tokens[0].type)
    }

    // Exception test

    @Test
    fun test046_exceptionTest() {
        assertFailsWith<LexerException>(
            block = {
                lexer.lex(src_046)
            }
        )
    }

    @Test
    fun test047_exceptionTest() {
        assertFailsWith<LexerException>(
            block = {
                lexer.lex(src_047)
            }
        )
    }

    @Test
    fun test048_exceptionTest() {
        assertFailsWith<LexerException>(
            block = {
                lexer.lex(src_048)
            }
        )
    }

    @Test
    fun test049_exceptionTest() {
        assertFailsWith<LexerException>(
            block = {
                lexer.lex(src_049)
            }
        )
    }

    @Test
    fun test050_exceptionTest() {
        assertFailsWith<LexerException>(
            block = {
                lexer.lex(src_050)
            }
        )
    }
}
