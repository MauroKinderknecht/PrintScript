import impl.LexerImpl
import interfaces.Lexer
import java.io.ByteArrayInputStream
import java.io.File
import java.io.InputStreamReader
import kotlin.test.Test
import kotlin.test.assertEquals

class LexerTest {

    private val lexer: Lexer = LexerImpl()

    private fun toInputStreamReader(text: String) = InputStreamReader(ByteArrayInputStream(text.toByteArray()))

    @Test
    fun stringDeclarationTest() {
        val tokens = lexer.lex("let a: String;")
        val expected = File("./src/test/kotlin/testLexer/testLexer1.txt").readText()
        assertEquals(tokens.toString(), expected)
    }

    @Test
    fun stringDoubleQuoteAssignationTest() {
        val tokens = lexer.lex("a = \"This is a test!\";")
        assertEquals(7, tokens.size)
    }

    @Test
    fun stringSingleQuoteAssignationTest() {
        val tokens = lexer.lex("a = \'This is a test!\';")
        assertEquals(7, tokens.size)
    }

    @Test
    fun stringDeclarationAssignationTest() {
        val tokens = lexer.lex("let a: String = \"This is a test!\";")
        assertEquals(12, tokens.size)
    }

    @Test
    fun numberDeclarationTest() {
        val tokens = lexer.lex("let a: Number;")
        assertEquals(8, tokens.size)
    }

    @Test
    fun numberIntegerAssignationTest() {
        val tokens = lexer.lex("a = 2;")
        assertEquals(7, tokens.size)
    }

    @Test
    fun numberDeclarationAssignationTest() {
        val tokens = lexer.lex("let a: String = 2.123;")
        assertEquals(12, tokens.size)
    }

    @Test
    fun printStringTest() {
        val tokens = lexer.lex("println(\"This is a test!\");")
        assertEquals(6, tokens.size)
    }

    @Test
    fun printNumberTest() {
        val tokens = lexer.lex("println(1.123);")
        assertEquals(6, tokens.size)
    }

    @Test
    fun newLineTest() {
        val tokens = lexer.lex("a = 1.123;\nb = \"Hello\";")
        val expected = File("./src/test/kotlin/testLexer/testNewLine.tokens.txt").readText()
        assertEquals(tokens.toString(), expected)
    }
}
