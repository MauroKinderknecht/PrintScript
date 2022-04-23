package impl

import data.*
import enums.TokenTypes
import exception.InterpreterException
import interfaces.ASTVisitor
import interfaces.ContextProvider
import interfaces.Interpreter
import java.util.function.Consumer

class InterpreterImpl(private var emitter: Consumer<String>, private var context: ContextProvider) : Interpreter, ASTVisitor {

    override fun interpret(tree: AST) {
        if (tree !is ProgramAST) throw InterpreterException("Not a PrintScript program", null)
        eval(tree)
    }

    private fun eval(tree: AST): Any = tree.accept(this)

    private fun isNumber(num: Any) = num is Number

    private fun isInt(num: Any) = num is Int

    private fun isString(str: Any) = str is String

    override fun visit(tree: ProgramAST): Any {
        return tree.children.forEach { statement ->
            eval(statement)
        }
    }

    override fun visit(tree: DeclarationAST): Any {
        val modifiable = when (tree.variable.token.type) {
            TokenTypes.LET -> true
            else -> throw InterpreterException("Type ${tree.variable.token.type} is not a variable", tree.variable.token.range)
        }
        return context.create(tree.identifier.content, tree.type.token.type, modifiable)
    }

    override fun visit(tree: IdentifierAST): Any = context.read(tree.identifier.content)

    override fun visit(tree: VariableAST): String = tree.variable.content

    override fun visit(tree: AssignationAST): Any {
        val variable = tree.lhs.accept(this)
        val expression = eval(tree.expression)
        return context.write(variable as String, expression)
    }

    override fun visit(tree: FunctionAST): Any {
        val expression = eval(tree.expression)

        return when (tree.function.token.type) {
            TokenTypes.PRINTLN -> {
                emitter.accept(expression.toString())
            }
            else -> throw InterpreterException("Function ${tree.function.content} does not exist", tree.function.token.range)
        }
    }

    override fun visit(tree: LiteralAST): Any {
        val content = tree.literal.content
        return when (tree.literal.token.type) {
            TokenTypes.STRING -> content.replace(Regex("[\"']"), "")
            TokenTypes.NUMBER -> if (content.contains('.')) content.toDouble() else content.toInt()
            else -> throw InterpreterException("Type ${tree.literal.token.type} does not exist", tree.literal.token.range)
        }
    }

    override fun visit(tree: BinaryExpressionAST): Any {
        val left = eval(tree.left)
        val right = eval(tree.right)

        return when (tree.operation.token.type) {
            TokenTypes.PLUS -> {
                if (
                    !isNumber(left) && !isString(left) ||
                    !isNumber(right) && !isString(left) ||
                    !isNumber(right) && !isString(right)
                ) throw InterpreterException("Expression expected", tree.operation.token.range)
                return if (isNumber(left)) {
                    if (isInt(left) && isInt(right)) left as Int + right as Int
                    else (left as Number).toDouble() + (right as Number).toDouble()
                } else left as String + right
            }
            TokenTypes.MINUS -> {
                if (!isNumber(left) || !isNumber(right)) throw InterpreterException("Expression expected", tree.operation.token.range)
                return if (isInt(left) && isInt(right)) left as Int - right as Int
                else (left as Number).toDouble() - (right as Number).toDouble()
            }
            TokenTypes.TIMES -> {
                if (!isNumber(left) || !isNumber(right)) throw InterpreterException("Expression expected", tree.operation.token.range)
                if (isInt(left) && isInt(right)) left as Int * right as Int
                else (left as Number).toDouble() * (right as Number).toDouble()
            }
            TokenTypes.DIVIDEDBY -> {
                if (!isNumber(left) || !isNumber(right)) throw InterpreterException("Expression expected", tree.operation.token.range)
                else (left as Number).toDouble() / (right as Number).toDouble()
            }
            else -> throw InterpreterException("Expression expected", tree.operation.token.range)
        }
    }

    override fun visit(tree: UnaryExpressionAST): Any {
        val right = eval(tree.right)

        return when (tree.operation.token.type) {
            TokenTypes.MINUS -> {
                if (!isNumber(right)) throw InterpreterException("Expression expected", tree.operation.token.range)
                - (right as Double)
            }
            else -> throw InterpreterException("Expression expected", tree.operation.token.range)
        }
    }
}
