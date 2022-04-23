import enums.MenuOption
import enums.TokenTypes
import impl.*
import interfaces.*
import java.util.*

class CLI {

    private val context: ContextProvider
    private val lexer: Lexer
    private val parser: Parser
    private val interpreter: Interpreter

    init {
        val matchers: EnumMap<TokenTypes, LexerMatcher> = EnumMap(TokenTypes::class.java)

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

        val expressions = listOf(
            IdentifierExpression::class,
            LiteralExpression::class,
            UnaryExpression::class,
            AddSubtExpression::class,
            MultDivExpression::class,
            ParenthesisExpression::class
        )

        val statements = listOf(
            DeclarationStatement::class,
            AssignationStatement::class,
            DeclarationStatement::class,
            DeclarationAssignationStatement::class,
            FunctionStatement::class
        )

        val expressionMatcher = ExpressionMatcher(expressions)
        val statementMatcher = StatementMatcher(statements, expressionMatcher)

        context = ContextProviderImpl()
        lexer = LexerImpl(matchers)
        parser = ParserImpl(statementMatcher)
        interpreter = InterpreterImpl(System.out::println, context)
    }

    private fun interpret(src: String, messages: Boolean) {
        if (messages) println("Lexing...")
        val tokens = lexer.lex(src)
        if (messages) println("Parsing...")
        val ast = parser.parse(src, tokens)
        if (messages) println("Interpreting...")
        interpreter.interpret(ast)
    }

    private fun printScript() {
        println(
            "██████  ██████  ██ ███    ██ ████████ ███████  ██████ ██████  ██ ██████  ████████ \n" +
                "██   ██ ██   ██ ██ ████   ██    ██    ██      ██      ██   ██ ██ ██   ██    ██    \n" +
                "██████  ██████  ██ ██ ██  ██    ██    ███████ ██      ██████  ██ ██████     ██    \n" +
                "██      ██   ██ ██ ██  ██ ██    ██         ██ ██      ██   ██ ██ ██         ██    \n" +
                "██      ██   ██ ██ ██   ████    ██    ███████  ██████ ██   ██ ██ ██         ██    \n" +
                "\n" +
                "_________________________________________________________________________________ \n" +
                "\n"
        )
    }

    fun run() {
        printScript()
        var exit = false
        while (!exit) {
            when (menu()) {
                MenuOption.REPL -> {
                    repl()
                    exit = true
                }
                MenuOption.FILE -> readFromFile()
                MenuOption.EXIT -> exit = true
            }
        }
    }

    private fun menu(): MenuOption {
        println(
            "Select an option: \n" +
                "1. REPL \n" +
                "2. Read from File \n" +
                "3. Exit \n"
        )

        return try {
            when (val option = readln().toInt()) {
                1 -> MenuOption.REPL
                2 -> MenuOption.FILE
                3 -> MenuOption.EXIT
                else -> {
                    println("Oops, $option is not a valid option. Please enter a valid option.")
                    menu()
                }
            }
        } catch (_: java.lang.NumberFormatException) {
            println("Please enter a number")
            menu()
        }
    }

    private fun repl() {
        while (true) {
            print("PrintScript > ")
            interpret(readln(), false)
        }
    }

    private fun readFromFile() {
        val a = "println('Hello world!')"
        interpret(a, true)
    }
}

fun main() = CLI().run()
