package impl

import enums.PrintScriptVersion
import kotlin.reflect.KClass

class SyntaxElementsProvider {

    companion object {

        fun getExpressionElements(version: PrintScriptVersion): Pair<List<KClass<out Statement>>, List<KClass<out Expression>>> {
            return when (version) {
                PrintScriptVersion.V1_0 -> {
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

                    Pair(statements, expressions)
                }
                PrintScriptVersion.V1_1 -> {
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
                        FunctionStatement::class,
                        IfStatement::class,
                        IfElseStatement::class
                    )

                    Pair(statements, expressions)
                }
            }
        }
    }
}
