import exception.InterpreterException
import fixtures.*
import impl.ContextProviderImpl
import impl.InterpreterImpl
import interfaces.ContextProvider
import interfaces.Interpreter
import org.junit.jupiter.api.Test
import java.util.function.Consumer
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class InterpreterTest {

    private val contextProvider: ContextProvider
    private val interpreter: Interpreter
    private val consumer: Consumer<String>

    init {
        contextProvider = ContextProviderImpl()
        consumer = TestConsumer()
        interpreter = InterpreterImpl(consumer, ::readln, contextProvider)
    }

    // V1 tests

    @Test
    fun test001_programAST() {
        val ast = ast_001
        interpreter.interpret(ast)
        assertTrue(contextProvider.isEmpty())
    }

    @Test
    fun test002_StringDeclarationAST() {
        val ast = ast_002
        interpreter.interpret(ast)
        assertFalse(contextProvider.isEmpty())
        assertEquals(context_002.toString(), contextProvider.toString())
    }

    @Test
    fun test003_DoubleQuotedStringAssignationAST() {
        val ast = ast_003
        interpreter.interpret(ast)
        assertFalse(contextProvider.isEmpty())
        assertEquals(context_003.toString(), contextProvider.toString())
    }

    @Test
    fun test004_SingleQuotedStringAssignationAST() {
        val ast = ast_004
        interpreter.interpret(ast)
        assertFalse(contextProvider.isEmpty())
        assertEquals(context_004.toString(), contextProvider.toString())
    }

    @Test
    fun test005_StringDeclarationAssignationAST() {
        val ast = ast_005
        interpreter.interpret(ast)
        assertFalse(contextProvider.isEmpty())
        assertEquals(context_005.toString(), contextProvider.toString())
    }

    @Test
    fun test006_NumberDeclarationAST() {
        val ast = ast_006
        interpreter.interpret(ast)
        assertFalse(contextProvider.isEmpty())
        assertEquals(context_006.toString(), contextProvider.toString())
    }

    @Test
    fun test007_NumberAssignationAST() {
        val ast = ast_007
        interpreter.interpret(ast)
        assertFalse(contextProvider.isEmpty())
        assertEquals(context_007.toString(), contextProvider.toString())
    }

    @Test
    fun test008_NumberDeclarationAssignationAST() {
        val ast = ast_008
        interpreter.interpret(ast)
        assertFalse(contextProvider.isEmpty())
        assertEquals(context_008.toString(), contextProvider.toString())
    }

    @Test
    fun test009_StringPrintlnAST() {
        val ast = ast_009
        interpreter.interpret(ast)
        assertTrue(contextProvider.isEmpty())
        assertEquals(context_009.toString(), consumer.toString())
    }

    @Test
    fun test010_NumberPrintlnAST() {
        val ast = ast_010
        interpreter.interpret(ast)
        assertTrue(contextProvider.isEmpty())
        assertEquals(context_010.toString(), consumer.toString())
    }

    @Test
    fun test011_MultilineProgramAST() {
        val ast = ast_011
        interpreter.interpret(ast)
        assertFalse(contextProvider.isEmpty())
        assertEquals(context_011.toString(), contextProvider.toString())
    }

    @Test
    fun test012_AdditionAST() {
        val ast = ast_012
        interpreter.interpret(ast)
        assertFalse(contextProvider.isEmpty())
        assertEquals(context_012.toString(), contextProvider.toString())
    }

    @Test
    fun test013_SubtractionAST() {
        val ast = ast_013
        interpreter.interpret(ast)
        assertFalse(contextProvider.isEmpty())
        assertEquals(context_013.toString(), contextProvider.toString())
    }

    @Test
    fun test014_ProductAST() {
        val ast = ast_014
        interpreter.interpret(ast)
        assertFalse(contextProvider.isEmpty())
        assertEquals(context_014.toString(), contextProvider.toString())
    }

    @Test
    fun test015_DivisionAST() {
        val ast = ast_015
        interpreter.interpret(ast)
        assertFalse(contextProvider.isEmpty())
        assertEquals(context_015.toString(), contextProvider.toString())
    }

    @Test
    fun test016_AssignAnotherVariableAST() {
        val ast = ast_016
        interpreter.interpret(ast)
        assertFalse(contextProvider.isEmpty())
        assertEquals(context_016.toString(), contextProvider.toString())
    }

    @Test
    fun test017_AdditionOfVariablesAST() {
        val ast = ast_017
        interpreter.interpret(ast)
        assertFalse(contextProvider.isEmpty())
        assertEquals(context_017.toString(), contextProvider.toString())
    }

    @Test
    fun test018_ComplexAndSimpleExpressionAST() {
        val ast = ast_018
        interpreter.interpret(ast)
        assertFalse(contextProvider.isEmpty())
        assertEquals(context_018.toString(), contextProvider.toString())
    }

    @Test
    fun test019_ParenthesisExpressionAST() {
        val ast = ast_019
        interpreter.interpret(ast)
        assertFalse(contextProvider.isEmpty())
        assertEquals(context_019.toString(), contextProvider.toString())
    }

    @Test
    fun test020_ComplexExpressionAST() {
        val ast = ast_020
        interpreter.interpret(ast)
        assertFalse(contextProvider.isEmpty())
        assertEquals(context_020.toString(), contextProvider.toString())
    }

    @Test
    fun test021_SimpleAndComplexExpressionAST() {
        val ast = ast_021
        interpreter.interpret(ast)
        assertFalse(contextProvider.isEmpty())
        assertEquals(context_021.toString(), contextProvider.toString())
    }

    @Test
    fun test022_PrecedenceExpressionAST() {
        val ast = ast_022
        interpreter.interpret(ast)
        assertFalse(contextProvider.isEmpty())
        assertEquals(context_022.toString(), contextProvider.toString())
    }

    @Test
    fun test023_noProgramAST() {
        assertFailsWith<InterpreterException> {
            val ast = ast_023
            interpreter.interpret(ast)
        }
    }

    @Test
    fun test024_variableNotInitializedAST() {
        assertFailsWith<InterpreterException> {
            val ast = ast_024
            interpreter.interpret(ast)
        }
    }

    @Test
    fun test025_variableAlreadyInitializedAST() {
        assertFailsWith<InterpreterException> {
            val ast = ast_025
            interpreter.interpret(ast)
        }
    }
}
