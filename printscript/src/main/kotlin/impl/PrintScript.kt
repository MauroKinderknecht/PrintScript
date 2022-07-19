package impl

import enums.PrintScriptVersion
import exception.PrintScriptException
import interfaces.*
import java.util.function.Consumer

class PrintScript(
    private val emitter: Consumer<String>,
    private val errorHandler: Consumer<String>,
    reader: (String) -> (String),
    version: String,
    private val verbose: Boolean
) {
    private val context: ContextProvider
    private val lexer: Lexer
    private val parser: Parser
    private val interpreter: Interpreter

    init {

        val psVersion = when (version) {
            "1.0" -> PrintScriptVersion.V1_0
            "1.1" -> PrintScriptVersion.V1_1
            else -> throw PrintScriptException("Unknown target version")
        }

        val matchers = MatcherProvider.getMatchers(psVersion)
        lexer = LexerImpl(matchers)

        val (statements, expressions) = SyntaxElementsProvider.getExpressionElements(psVersion)
        val expressionMatcher = ExpressionMatcher(expressions)
        val statementMatcher = StatementMatcher(statements, expressionMatcher)
        parser = ParserImpl(statementMatcher)

        context = ContextProviderImpl()
        interpreter = InterpreterImpl(emitter, reader, context)
    }

    fun getContext(): ContextProvider = context

    fun interpret(source: String) {
        try {
            if (verbose) emitter.accept("Lexing...")
            val tokens = lexer.lex(source)
            if (verbose) emitter.accept("Parsing...")
            val ast = parser.parse(source, tokens)
            if (verbose) emitter.accept("Interpreting...")
            interpreter.interpret(ast)
            if (verbose) emitter.accept("Finished.")
        } catch (e: PrintScriptException) {
            errorHandler.accept(e.toString())
        }
    }

    fun validate(source: String) {
        try {
            emitter.accept("Lexing...")
            val tokens = lexer.lex(source)
            emitter.accept("Parsing...")
            val ast = parser.parse(source, tokens)
            emitter.accept("Interpreting...")
            interpreter.validate(ast)
            emitter.accept("Finished.")
        } catch (e: PrintScriptException) {
            errorHandler.accept(e.toString())
        }
    }
}
