
import impl.ParserImpl
import interfaces.Parser
import kotlin.test.Test
import kotlin.test.assertEquals

class ParserTest {

    private val parser: Parser = ParserImpl()

    @Test
    fun test001_stringDeclarationTest() {
        val tokens = tokens_001
        val ast = ast_001.toString()
        val tree = parser.parse(src_001, tokens)

        assertEquals(ast, tree.toString())
    }

    @Test
    fun test002_stringDoubleQuoteAssignationTest() {
        val tokens = tokens_002
        val ast = ast_002.toString()
        val tree = parser.parse(src_002, tokens)

        assertEquals(ast, tree.toString())
    }

    @Test
    fun test003_stringSingleQuoteAssignationTest() {
        val tokens = tokens_003
        val ast = ast_003.toString()
        val tree = parser.parse(src_003, tokens)

        assertEquals(ast, tree.toString())
    }

    @Test
    fun test004_stringDeclarationAssignationTest() {
        val tokens = tokens_004
        val ast = ast_004.toString()
        val tree = parser.parse(src_004, tokens)

        assertEquals(ast, tree.toString())
    }

    @Test
    fun test005_numberDeclarationTest() {
        val tokens = tokens_005
        val ast = ast_005.toString()
        val tree = parser.parse(src_005, tokens)

        assertEquals(ast, tree.toString())
    }

    @Test
    fun test006_numberIntegerAssignationTest() {
        val tokens = tokens_006
        val ast = ast_006.toString()
        val tree = parser.parse(src_006, tokens)

        assertEquals(ast, tree.toString())
    }

    @Test
    fun test007_numberDeclarationAssignationTest() {
        val tokens = tokens_007
        val ast = ast_007.toString()
        val tree = parser.parse(src_007, tokens)

        assertEquals(ast, tree.toString())
    }

    @Test
    fun test008_printStringTest() {
        val tokens = tokens_008
        val ast = ast_008.toString()
        val tree = parser.parse(src_008, tokens)

        assertEquals(ast, tree.toString())
    }

    @Test
    fun test009_printNumberTest() {
        val tokens = tokens_009
        val ast = ast_009.toString()
        val tree = parser.parse(src_009, tokens)

        assertEquals(ast, tree.toString())
    }

    @Test
    fun test010_newLineTest() {
        val tokens = tokens_010
        val ast = ast_010.toString()
        val tree = parser.parse(src_010, tokens)

        assertEquals(ast, tree.toString())
    }

    @Test
    fun test011_additionTest() {
        val tokens = tokens_011
        val ast = ast_011.toString()
        val tree = parser.parse(src_011, tokens)

        assertEquals(ast, tree.toString())
    }

    @Test
    fun test012_subtractionTest() {
        val tokens = tokens_012
        val ast = ast_012.toString()
        val tree = parser.parse(src_012, tokens)

        assertEquals(ast, tree.toString())
    }

    @Test
    fun test013_multiplicationTest() {
        val tokens = tokens_013
        val ast = ast_013.toString()
        val tree = parser.parse(src_013, tokens)

        assertEquals(ast, tree.toString())
    }

    @Test
    fun test014_divisionTest() {
        val tokens = tokens_014
        val ast = ast_014.toString()
        val tree = parser.parse(src_014, tokens)

        assertEquals(ast, tree.toString())
    }
}
