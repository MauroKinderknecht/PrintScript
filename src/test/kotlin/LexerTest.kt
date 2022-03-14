import impl.LexerImpl
import interfaces.Lexer
import java.io.ByteArrayInputStream
import java.io.InputStreamReader
import kotlin.test.Test

class LexerTest {

    val lexer: Lexer = LexerImpl()

    @Test
    fun lexerTest() {
        val tokens = lexer.lex(InputStreamReader(ByteArrayInputStream(("let a: String = \"This is a test!\";").toByteArray())))
        println(tokens.map { token -> token.type })
        assert(true)
    }

}