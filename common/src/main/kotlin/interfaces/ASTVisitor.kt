package interfaces

import data.*

interface ASTVisitor {
    fun visit(tree: ProgramAST): Any
    fun visit(tree: DeclarationAST): Any
    fun visit(tree: IdentifierAST): Any
    fun visit(tree: AssignationAST): Any
    fun visit(tree: FunctionAST): Any
    fun visit(tree: LiteralAST): Any
    fun visit(tree: BinaryExpressionAST): Any
    fun visit(tree: UnaryExpressionAST): Any
    fun visit(tree: VariableAST): Any
}