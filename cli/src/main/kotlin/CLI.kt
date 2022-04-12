import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt
import enums.TokenTypes
import impl.*
import interfaces.Interpreter
import interfaces.Lexer
import interfaces.LexerMatcher
import interfaces.Parser
import java.util.*

class CLI: CliktCommand() {
    private val file: String by option(help="File to interpret").prompt("Filename")

    private val matchers: EnumMap<TokenTypes, LexerMatcher> = EnumMap(TokenTypes::class.java)

    init {
        // Keywords
        matchers[TokenTypes.LET] = LexerMatcherImpl(TokenTypes.LET, "let")
        matchers[TokenTypes.PRINTLN] = LexerMatcherImpl(TokenTypes.PRINTLN, "println")

        // Types
        matchers[TokenTypes.TYPESTRING] = LexerMatcherImpl(TokenTypes.TYPESTRING, "String")
        matchers[TokenTypes.TYPENUMBER] = LexerMatcherImpl(TokenTypes.TYPENUMBER, "Number")

        // Operations
        matchers[TokenTypes.PLUS] = LexerMatcherImpl(TokenTypes.PLUS, "[+]")
        matchers[TokenTypes.MINUS] = LexerMatcherImpl(TokenTypes.MINUS, "[-]")
        matchers[TokenTypes.TIMES] = LexerMatcherImpl(TokenTypes.TIMES, "[*]")
        matchers[TokenTypes.DIVIDEDBY] = LexerMatcherImpl(TokenTypes.DIVIDEDBY, "[/]")
        matchers[TokenTypes.ASSIGNMENT] = LexerMatcherImpl(TokenTypes.ASSIGNMENT, "[=]")
        matchers[TokenTypes.OPENPAREN] = LexerMatcherImpl(TokenTypes.OPENPAREN, "[(]")
        matchers[TokenTypes.CLOSEPAREN] = LexerMatcherImpl(TokenTypes.CLOSEPAREN, "[)]")

        // Declarations
        matchers[TokenTypes.NUMBER] = LexerMatcherImpl(TokenTypes.NUMBER, "-?\\d+\\.?\\d*")
        matchers[TokenTypes.STRING] = LexerMatcherImpl(TokenTypes.STRING, "\".*\"|\'.*\'")

        // Variables
        matchers[TokenTypes.IDENTIFIER] = LexerMatcherImpl(TokenTypes.IDENTIFIER, "[_a-zA-Z][_a-zA-Z0-9]*")
    }

    override fun run() {
        val exp = listOf(UnaryExpression::class, BinaryExpression::class)
        val stm = listOf(
            DeclarationStatement::class,
            AssignationStatement::class,
            DeclarationStatement::class,
            DeclarationAssignationStatement::class,
            FunctionStatement::class
        )

        val expressionMatcher = ExpressionMatcher(exp)
        val statementMatcher = StatementMatcher(stm, expressionMatcher)

        val lexer: Lexer = LexerImpl(matchers)
        val parser: Parser = ParserImpl(statementMatcher)
        val interpreter: Interpreter = InterpreterImpl(System.out::println)

        val src = "let a: Number = 0;\n" + "println(a);\n" + "a = 20;\n" + "println(a);\n" +
                "a = a + 50;\n" + "println(a);\n" + "let b: String = \"Hello World\";\n" + "print(b);"

        println("Lexing...")
        val tokens = lexer.lex(src)
        println("Parsing...")
        val ast = parser.parse(src, tokens)
        println("Interpreting...")
        val result = interpreter.interpret(ast)
        print(result)
    }


}

fun main(args: Array<String>) = CLI().main(args)