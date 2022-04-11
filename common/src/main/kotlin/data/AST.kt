package data

import enums.ASTType
import org.austral.ingsis.printscript.parser.Content

// Head AST

open class AST(name: ASTType)

// AST subtypes (to enforce correct structuring)

data class ProgramAST(private var children: List<AST> = emptyList<AST>().toMutableList()) : AST(ASTType.PROGRAM) {
    fun add(statement: AST) {
        children = children + statement
    }
}

data class DeclarationAST(val variable: Content<String>, val identifier: Content<String>, val type: Content<String>) : AST(ASTType.DECLARATION)

data class IdentifierAST(val identifier: Content<String>) : AST(ASTType.IDENTIFIER)

data class AssignationAST(val lhs: AST, val expression: AST) : AST(ASTType.ASSIGNATION)

data class PrintlnAST(val expression: AST) : AST(ASTType.PRINT)

data class LiteralAST(val literal: Content<String>) : AST(ASTType.LITERAL)

data class ExpressionAST(val left: AST, val operation: Content<String>, val right: AST) : AST(ASTType.EXPRESSION)
