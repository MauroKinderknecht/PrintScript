package impl

import data.*
import enums.TokenTypes
import exception.InterpreterException
import impl.Context.Companion.emptyContext
import interfaces.ASTVisitor
import interfaces.Interpreter
import java.util.function.Consumer

class InterpreterImpl(private var emitter: Consumer<String>) : Interpreter, ASTVisitor {

    private val context = emptyContext()

    override fun interpret(tree: AST) {
        if (tree !is ProgramAST) throw InterpreterException("Program AST not found")
        eval(tree)
    }

    private fun eval(tree: AST): Any = tree.accept(this)

    private fun isNumber(num: Any) = num is Number

    private fun isString(str: Any) = str is String

    override fun visit(tree: ProgramAST): Any {
        return tree.children.forEach { statement ->
            eval(statement)
        }
    }

    override fun visit(tree: DeclarationAST): Any = context.create(tree.variable.content, tree.type.content)

    override fun visit(tree: IdentifierAST): Any = context.read(tree.identifier.content)

    override fun visit(tree: VariableAST): Any = tree.variable.content

    override fun visit(tree: AssignationAST): Any {
        val variable = eval(tree.lhs)
        val expression = eval(tree.expression)
        return context.write(variable as String, expression)
    }

    override fun visit(tree: FunctionAST): Any {
        val expression = eval(tree.expression)

        return when (tree.function.token.type) {
            TokenTypes.PRINTLN -> {
                emitter.accept(expression.toString())
            }
            else -> throw InterpreterException("Function does not exists")
        }
    }

    override fun visit(tree: LiteralAST): Any {
        val content = tree.literal.content
        return when (tree.literal.token.type) {
            TokenTypes.STRING -> content.replace("\" | \'", "")
            TokenTypes.NUMBER -> content.toDouble()
            else -> InterpreterException("type not supported")
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
                ) throw InterpreterException("Expression exprected")
                return if (isNumber(left)) left as Double + right as Double
                else left as String + right
            }
            TokenTypes.MINUS -> {
                if (!isNumber(left) || !isNumber(right)) throw InterpreterException("Expression expected")
                left as Double - right as Double
            }
            TokenTypes.TIMES -> {
                if (!isNumber(left) || !isNumber(right)) throw InterpreterException("Expression expected")
                left as Double * right as Double
            }
            TokenTypes.DIVIDEDBY -> {
                if (!isNumber(left) || !isNumber(right)) throw InterpreterException("Expression expected")
                left as Double / right as Double
            }
            else -> throw InterpreterException("Expression exprected")
        }
    }

    override fun visit(tree: UnaryExpressionAST): Any {
        val right = eval(tree.right)

        return when (tree.operation.token.type) {
            TokenTypes.MINUS -> {
                if (!isNumber(right)) throw InterpreterException("No es un Number capo")
                - (right as Double)
            }
            else -> throw InterpreterException("Expression exprected")
        }
    }
}
