package data

import interfaces.ASTVisitor
import org.austral.ingsis.printscript.parser.Content

// Head AST

abstract class AST() {
    abstract fun accept(visitor: ASTVisitor): Any
}

// AST subtypes (to enforce correct structuring)

data class ProgramAST(var children: List<AST> = emptyList<AST>().toMutableList()) : AST() {
    fun add(statement: AST) {
        children = children + statement
    }

    override fun accept(visitor: ASTVisitor) = visitor.visit(this)
}

data class DeclarationAST(val variable: Content<String>, val identifier: Content<String>, val type: Content<String>) : AST() {
    override fun accept(visitor: ASTVisitor) = visitor.visit(this)
}

data class VariableAST(val variable: Content<String>) : AST() {
    override fun accept(visitor: ASTVisitor) = visitor.visit(this)
}

data class IdentifierAST(val identifier: Content<String>) : AST() {
    override fun accept(visitor: ASTVisitor) = visitor.visit(this)
}

data class AssignationAST(val lhs: AST, val expression: AST) : AST() {
    override fun accept(visitor: ASTVisitor) = visitor.visit(this)
}

data class VoidFunctionAST(val function: Content<String>, val expression: AST) : AST() {
    override fun accept(visitor: ASTVisitor) = visitor.visit(this)
}

data class LiteralAST(val literal: Content<String>) : AST() {
    override fun accept(visitor: ASTVisitor) = visitor.visit(this)
}

data class BinaryExpressionAST(val left: AST, val operation: Content<String>, val right: AST) : AST() {
    override fun accept(visitor: ASTVisitor) = visitor.visit(this)
}

data class UnaryExpressionAST(val operation: Content<String>, val right: AST) : AST() {
    override fun accept(visitor: ASTVisitor) = visitor.visit(this)
}

data class BlockAST(val statements: List<AST>) : AST() {
    override fun accept(visitor: ASTVisitor) = visitor.visit(this)
}

data class IfAST(val condition: AST, val truthy: AST) : AST() {
    override fun accept(visitor: ASTVisitor) = visitor.visit(this)
}

data class IfElseAST(val condition: AST, val truthy: AST, val falsy: AST) : AST() {
    override fun accept(visitor: ASTVisitor) = visitor.visit(this)
}

data class FunctionCallAST(val function: Content<String>) : AST() {
    override fun accept(visitor: ASTVisitor) = visitor.visit(this)
}
