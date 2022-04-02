import fixtures.tokens_001
import impl.ParserImpl
import interfaces.Parser
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class ParserTest {

    private val parser: Parser = ParserImpl()

    @Test
    fun test001_stringDeclarationTest() {
        val tokens = tokens_001
        val tree = parser.parse("let a: String;", tokens)
    }
}