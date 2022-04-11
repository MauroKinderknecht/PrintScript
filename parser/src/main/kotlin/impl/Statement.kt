package impl

import data.*
import enums.SyntaxElements
import interfaces.Syntax
import interfaces.SyntaxMatcher
import org.austral.ingsis.printscript.parser.Content

abstract class Statement : Syntax {

    fun parseExpression(content: List<Content<String>>): AST? {
        return ExpressionMatcher().match(content)
    }
}

class StatementMatcher : SyntaxMatcher {

    private var statements: MutableList<Statement> = emptyList<Statement>().toMutableList()

    init {
        statements.add(DeclarationStatement())
        statements.add(AssignationStatement())
        statements.add(DeclarationAssignationStatement())
        statements.add(PrintlnStatement())
    }

    // return first not null parsed ast
    override fun match(content: List<Content<String>>): AST? =
        statements.firstNotNullOfOrNull { statement -> statement.parse(content) }
}

// (variable) (identifier) (type_assignment) (type) (end)
class DeclarationStatement : Statement() {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size != 4) return null

        val variable = if (SyntaxElements.VARIABLE.contains(content[0].token.type)) content[0] else null
        val identifier = if (SyntaxElements.IDENTIFIER.contains(content[1].token.type)) content[1] else null
        val colon = if (SyntaxElements.TYPEASSIGNMENT.contains(content[2].token.type)) content[2] else null
        val type = if (SyntaxElements.TYPE.contains(content[3].token.type)) content[3] else null

        return if (variable != null && identifier != null && colon != null && type != null)
            DeclarationAST(variable, identifier, type)
        else null
    }
}

// (identifier) (assignment) (expression)
class AssignationStatement : Statement() {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size < 3) return null

        val identifier = if (SyntaxElements.IDENTIFIER.contains(content[0].token.type)) content[0] else null
        val assignment = if (SyntaxElements.ASSIGNMENT.contains(content[1].token.type)) content[1] else null
        val expression = parseExpression(content.subList(2, content.size))

        return if (identifier != null && assignment != null && expression != null)
            AssignationAST(IdentifierAST(identifier), expression)
        else null
    }
}

// (variable) (identifier) (type_assignment) (type) (assignment) (expression)
class DeclarationAssignationStatement : Statement() {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size < 6) return null

        val variable = if (SyntaxElements.VARIABLE.contains(content[0].token.type)) content[0] else null
        val identifier = if (SyntaxElements.IDENTIFIER.contains(content[1].token.type)) content[1] else null
        val colon = if (SyntaxElements.TYPEASSIGNMENT.contains(content[2].token.type)) content[2] else null
        val type = if (SyntaxElements.TYPE.contains(content[3].token.type)) content[3] else null
        val assignment = if (SyntaxElements.ASSIGNMENT.contains(content[4].token.type)) content[4] else null
        val expression = parseExpression(content.subList(5, content.size))

        return if (variable != null && identifier != null && colon != null && type != null &&
            assignment != null && expression != null
        )
            AssignationAST(
                DeclarationAST(variable, identifier, type),
                expression
            )
        else null
    }
}

// (println) ( ( ) (expression) ( ) )
class PrintlnStatement : Statement() {
    override fun parse(content: List<Content<String>>): AST? {
        if (content.size < 4) return null

        val println = if (SyntaxElements.PRINTLN.contains(content[0].token.type)) content[0] else null
        val open = if (SyntaxElements.OPENPAREN.contains(content[1].token.type)) content[1] else null
        val expression = parseExpression(content.subList(2, content.size - 1))
        val close = if (SyntaxElements.CLOSEPAREN.contains(content[content.size - 1].token.type)) content[content.size - 1] else null

        return if (println != null && open != null && expression != null && close != null)
            PrintlnAST(expression)
        else null
    }
}
