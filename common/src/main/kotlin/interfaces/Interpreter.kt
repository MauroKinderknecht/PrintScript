package interfaces

import data.AST

interface Interpreter {
    fun interpret(tree: AST)
    fun validate(tree: AST): Boolean
}
