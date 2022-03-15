import impl.LexerImpl
import interfaces.Lexer
import java.io.ByteArrayInputStream
import java.io.InputStreamReader
import kotlin.test.Test
import kotlin.test.assertEquals

class LexerTest {

    private val lexer: Lexer = LexerImpl()

    private fun toInputStreamReader(text: String) = InputStreamReader(ByteArrayInputStream(text.toByteArray()))

    @Test
    fun stringDeclarationTest() {
        val tokens = lexer.lex(toInputStreamReader("let a: String;"))
        assertEquals(8, tokens.size)
    }

    @Test
    fun stringDoubleQuoteAssignationTest() {
        val tokens = lexer.lex(toInputStreamReader("a = \"This is a test!\";"))
        assertEquals(7, tokens.size)
    }

    @Test
    fun stringSingleQuoteAssignationTest() {
        val tokens = lexer.lex(toInputStreamReader("a = \'This is a test!\';"))
        assertEquals(7, tokens.size)
    }

    @Test
    fun stringDeclarationAssignationTest() {
        val tokens = lexer.lex(toInputStreamReader("let a: String = \"This is a test!\";"))
        assertEquals(12, tokens.size)
    }

    @Test
    fun numberDeclarationTest() {
        val tokens = lexer.lex(toInputStreamReader("let a: Number;"))
        assertEquals(8, tokens.size)
    }

    @Test
    fun numberIntegerAssignationTest() {
        val tokens = lexer.lex(toInputStreamReader("a = 2;"))
        assertEquals(7, tokens.size)
    }

    @Test
    fun numberFloatAssignationTest() {
        val tokens = lexer.lex(toInputStreamReader("a = 2;"))
        assertEquals(7, tokens.size)
    }

    @Test
    fun numberDeclarationAssignationTest() {
        val tokens = lexer.lex(toInputStreamReader("let a: String = 2.123;"))
        assertEquals(12, tokens.size)
    }

    @Test
    fun printStringTest() {
        val tokens = lexer.lex(toInputStreamReader("println(\"This is a test!\");"))
        assertEquals(6, tokens.size)
    }

    @Test
    fun printNumberTest() {
        val tokens = lexer.lex(toInputStreamReader("println(1.123);"))
        assertEquals(6, tokens.size)
    }

    @Test
    fun newLineTest() {
        val tokens = lexer.lex(toInputStreamReader("a = 1.123;\nb = \"Hello\";"))
        assertEquals(13, tokens.size)
    }

}