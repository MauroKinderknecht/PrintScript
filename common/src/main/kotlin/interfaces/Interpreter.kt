package interfaces

import data.ASTTree

interface Interpreter {
    fun interpret(tree: ASTTree)
}
