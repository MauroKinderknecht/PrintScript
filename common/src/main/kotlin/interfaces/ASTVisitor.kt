package interfaces

import data.*

interface ASTVisitor {
    fun visit(tree: ProgramAST): Any
    fun visit(tree: DeclarationAST): Any
    fun visit(tree: IdentifierAST): Any
    fun visit(tree: AssignationAST): Any
    fun visit(tree: VoidFunctionAST): Any
    fun visit(tree: FunctionCallAST): Any
    fun visit(tree: LiteralAST): Any
    fun visit(tree: BinaryExpressionAST): Any
    fun visit(tree: UnaryExpressionAST): Any
    fun visit(tree: VariableAST): Any
    fun visit(tree: BlockAST): Any
    fun visit(tree: IfAST): Any
    fun visit(tree: IfElseAST): Any
}
