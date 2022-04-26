package impl

import data.*
import enums.TokenTypes
import exception.InterpreterException
import interfaces.ASTVisitor
import interfaces.ContextProvider
import interfaces.Interpreter
import org.austral.ingsis.printscript.common.TokenType
import java.util.function.Consumer

class InterpreterImpl(private var emitter: Consumer<String>, private val reader: () -> (String), private var context: ContextProvider) : Interpreter, ASTVisitor {

    var isValidation: Boolean = false

    override fun interpret(tree: AST) {
        isValidation = false
        if (tree !is ProgramAST) throw InterpreterException("Not a PrintScript program", null)
        eval(tree)
    }

    override fun validate(tree: AST) {
        isValidation = true
        if (tree !is ProgramAST) throw InterpreterException("Not a PrintScript program", null)
        eval(tree)
    }

    private fun eval(tree: AST): Any = tree.accept(this)

    private fun isNumber(num: Any) = num is Number

    private fun isInt(num: Any) = num is Int

    private fun isString(str: Any) = str is String

    private fun isBoolean(str: Any) = str is Boolean

    override fun visit(tree: ProgramAST): Any = tree.children.forEach { eval(it) }

    override fun visit(tree: IdentifierAST): Any = context.read(tree.identifier.content)

    override fun visit(tree: VariableAST): String = tree.variable.content

    override fun visit(tree: BlockAST): Any = tree.statements.forEach { eval(it) }

    override fun visit(tree: DeclarationAST): Any {
        val modifiable = when (tree.variable.token.type) {
            TokenTypes.LET -> true
            TokenTypes.CONST -> false
            else -> throw InterpreterException("Type ${tree.variable.token.type} is not a variable", tree.variable.token.range)
        }
        val type = when (tree.type.token.type) {
            TokenTypes.TYPENUMBER -> TokenTypes.NUMBER
            TokenTypes.TYPESTRING -> TokenTypes.STRING
            TokenTypes.TYPEBOOLEAN -> TokenTypes.BOOLEAN
            else -> throw InterpreterException("Type ${tree.type.token.type} is not a data type", tree.type.token.range)
        }
        return context.create(tree.identifier.content, type, modifiable)
    }

    override fun visit(tree: AssignationAST): String {
        val variable = tree.lhs.accept(this)
        val (type, expression) = eval(tree.expression) as Pair<TokenType, Any>
        return context.write(variable as String, type, expression)
    }

    override fun visit(tree: VoidFunctionAST): Any {
        return when (tree.function.token.type) {
            TokenTypes.PRINTLN -> {
                val (_, expression) = eval(tree.expression) as Pair<TokenType, Any>
                if (!isValidation) emitter.accept(expression.toString())
                else Unit
            }
            else -> throw InterpreterException("Function ${tree.function.content} does not exist", tree.function.token.range)
        }
    }

    override fun visit(tree: FunctionCallAST): Any {
        return when (tree.function.token.type) {
            TokenTypes.READINPUT -> {
                val (_, argument) = eval(tree.arguments[0]) as Pair<TokenType, Any>
                emitter.accept(argument.toString())
                if (!isValidation) Pair(TokenTypes.STRING, reader())
                else Pair(TokenTypes.STRING, "placeholder")
            }
            else -> throw InterpreterException("Function ${tree.function.content} does not exist", tree.function.token.range)
        }
    }

    override fun visit(tree: LiteralAST): Pair<TokenType, Any> {
        val content = tree.literal.content
        return when (tree.literal.token.type) {
            TokenTypes.STRING -> Pair(TokenTypes.STRING, content.replace(Regex("[\"']"), ""))
            TokenTypes.NUMBER -> Pair(TokenTypes.NUMBER, if (content.contains('.')) content.toDouble() else content.toInt())
            TokenTypes.BOOLEAN -> Pair(TokenTypes.BOOLEAN, content.toBoolean())
            else -> throw InterpreterException("Type ${tree.literal.token.type} does not exist", tree.literal.token.range)
        }
    }

    override fun visit(tree: BinaryExpressionAST): Pair<TokenType, Any> {
        val (_, left) = eval(tree.left) as Pair<TokenType, Any>
        val (_, right) = eval(tree.right) as Pair<TokenType, Any>

        return when (tree.operation.token.type) {
            TokenTypes.PLUS -> {
                if (
                    isNumber(left) && !isNumber(right) ||
                    isBoolean(left)
                ) throw InterpreterException("Expression expected", tree.operation.token.range)
                if (isNumber(left)) {
                    Pair(
                        TokenTypes.NUMBER,
                        if (isInt(left) && isInt(right)) left as Int + right as Int
                        else (left as Number).toDouble() + (right as Number).toDouble()
                    )
                } else Pair(TokenTypes.STRING, left as String + right)
            }
            TokenTypes.MINUS -> {
                if (!isNumber(left) || !isNumber(right)) throw InterpreterException("Expression expected", tree.operation.token.range)
                Pair(
                    TokenTypes.NUMBER,
                    if (isInt(left) && isInt(right)) left as Int - right as Int
                    else (left as Number).toDouble() - (right as Number).toDouble()
                )
            }
            TokenTypes.TIMES -> {
                if (!isNumber(left) || !isNumber(right)) throw InterpreterException("Expression expected", tree.operation.token.range)
                Pair(
                    TokenTypes.NUMBER,
                    if (isInt(left) && isInt(right)) left as Int * right as Int
                    else (left as Number).toDouble() * (right as Number).toDouble()
                )
            }
            TokenTypes.DIVIDEDBY -> {
                if (!isNumber(left) || !isNumber(right)) throw InterpreterException("Expression expected", tree.operation.token.range)
                Pair(TokenTypes.NUMBER, (left as Number).toDouble() / (right as Number).toDouble())
            }
            else -> throw InterpreterException("Expression expected", tree.operation.token.range)
        }
    }

    override fun visit(tree: UnaryExpressionAST): Pair<TokenType, Any> {
        val right = eval(tree.right)

        return when (tree.operation.token.type) {
            TokenTypes.MINUS -> {
                if (!isNumber(right)) throw InterpreterException("Expression expected", tree.operation.token.range)
                Pair(TokenTypes.NUMBER, if (isInt(right)) - (right as Int) else - (right as Double))
            }
            else -> throw InterpreterException("Expression expected", tree.operation.token.range)
        }
    }

    override fun visit(tree: IfAST): Any {
        val (type, condition) = eval(tree.condition) as Pair<TokenType, Any>
        if (type != TokenTypes.BOOLEAN) throw InterpreterException("Boolean expression expected")
        return if (condition == true) eval(tree.truthy)
        else Unit
    }

    override fun visit(tree: IfElseAST): Any {
        val (type, condition) = eval(tree.condition) as Pair<TokenType, Any>
        if (type != TokenTypes.BOOLEAN) throw InterpreterException("Boolean expression expected")
        return if (condition == true) eval(tree.truthy)
        else eval(tree.falsy)
    }
}
