
import impl.ParserImpl
import interfaces.Parser
import kotlin.test.Test

class ParserTest {

    private val parser: Parser = ParserImpl()

    @Test
    fun test001_stringDeclarationTest() {
        val tokens = tokens_001
        val tree = parser.parse(src_001, tokens)
    }

    @Test
    fun test002_stringDoubleQuoteAssignationTest() {
        val tokens = tokens_002
        val tree = parser.parse(src_002, tokens)
    }

    @Test
    fun test003_stringSingleQuoteAssignationTest() {
        val tokens = tokens_003
        val tree = parser.parse(src_003, tokens)
    }

    @Test
    fun test004_stringDeclarationAssignationTest() {
        val tokens = tokens_004
        val tree = parser.parse(src_004, tokens)
    }

    @Test
    fun test005_numberDeclarationTest() {
        val tokens = tokens_005
        val tree = parser.parse(src_005, tokens)
    }

    @Test
    fun test006_numberIntegerAssignationTest() {
        val tokens = tokens_006
        val tree = parser.parse(src_006, tokens)
    }

    @Test
    fun test007_numberDeclarationAssignationTest() {
        val tokens = tokens_007
        val tree = parser.parse(src_007, tokens)
    }

    @Test
    fun test008_printStringTest() {
        val tokens = tokens_008
        val tree = parser.parse(src_008, tokens)
    }

    @Test
    fun test009_printNumberTest() {
        val tokens = tokens_009
        val tree = parser.parse(src_009, tokens)
    }

    @Test
    fun test010_newLineTest() {
        val tokens = tokens_010
        val tree = parser.parse(src_010, tokens)
    }

    @Test
    fun test011_additionTest() {
        val tokens = tokens_011
        val tree = parser.parse(src_011, tokens)
    }

    @Test
    fun test012_subtractionTest() {
        val tokens = tokens_012
        val tree = parser.parse(src_012, tokens)
    }

    @Test
    fun test013_multiplicationTest() {
        val tokens = tokens_013
        val tree = parser.parse(src_013, tokens)
    }

    @Test
    fun test014_divisionTest() {
        val tokens = tokens_014
        val tree = parser.parse(src_014, tokens)
    }
}
