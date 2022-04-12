package fixtures

import data.*
import org.austral.ingsis.printscript.parser.Content

val ast_001 = ProgramAST(
    children = listOf(
        DeclarationAST(
            variable = Content(content = "let", token = tokens_001[0]),
            identifier = Content(content = "a", token = tokens_001[2]),
            type = Content(content = "String", token = tokens_001[5])
        )
    )
)

val ast_002 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_002[0])),
            expression = LiteralAST(literal = Content(content = "\"This is a test!\"", token = tokens_002[4]))
        )
    )
)

val ast_003 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_003[0])),
            expression = LiteralAST(literal = Content(content = "\'This is a test!\'", token = tokens_003[4]))
        )
    )
)

val ast_004 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = DeclarationAST(
                variable = Content(content = "let", token = tokens_004[0]),
                identifier = Content(content = "a", token = tokens_004[2]),
                type = Content(content = "String", token = tokens_004[5])
            ),
            expression = LiteralAST(literal = Content(content = "\"This is a test!\"", token = tokens_004[9]))
        )
    )
)

val ast_005 = ProgramAST(
    children = listOf(
        DeclarationAST(
            variable = Content(content = "let", token = tokens_005[0]),
            identifier = Content(content = "a", token = tokens_005[2]),
            type = Content(content = "Number", token = tokens_005[5])
        )
    )
)

val ast_006 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_006[0])),
            expression = LiteralAST(literal = Content(content = "2", token = tokens_006[4]))
        )
    )
)

val ast_007 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = DeclarationAST(
                variable = Content(content = "let", token = tokens_007[0]),
                identifier = Content(content = "a", token = tokens_007[2]),
                type = Content(content = "Number", token = tokens_007[5])
            ),
            expression = LiteralAST(literal = Content(content = "2.123", token = tokens_007[9]))
        )
    )
)

val ast_008 = ProgramAST(
    children = listOf(
        FunctionAST(function = Content(content = "println", tokens_009[0]), LiteralAST(literal = Content(content = "\"This is a test!\"", token = tokens_008[2])))
    )
)

val ast_009 = ProgramAST(
    children = listOf(
        FunctionAST(function = Content(content = "println", tokens_009[0]), LiteralAST(literal = Content(content = "1.123", token = tokens_009[2])))
    )
)

val ast_010 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_010[0])),
            expression = LiteralAST(literal = Content(content = "1.123", token = tokens_010[4]))
        ),
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "b", token = tokens_010[7])),
            expression = LiteralAST(literal = Content(content = "\"Hello\"", token = tokens_010[11]))
        ),
    )
)

val ast_011 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_011[0])),
            expression = BinaryExpressionAST(
                left = LiteralAST(literal = Content(content = "2", token = tokens_011[4])),
                operation = Content(content = "+", token = tokens_011[6]),
                right = LiteralAST(literal = Content(content = "3", token = tokens_011[8]))
            )
        ),
    )
)

val ast_012 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_012[0])),
            expression = BinaryExpressionAST(
                left = LiteralAST(literal = Content(content = "2", token = tokens_012[4])),
                operation = Content(content = "-", token = tokens_012[6]),
                right = LiteralAST(literal = Content(content = "3", token = tokens_012[8]))
            )
        ),
    )
)

val ast_013 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_013[0])),
            expression = BinaryExpressionAST(
                left = LiteralAST(literal = Content(content = "2", token = tokens_013[4])),
                operation = Content(content = "*", token = tokens_013[6]),
                right = LiteralAST(literal = Content(content = "3", token = tokens_013[8]))
            )
        ),
    )
)

val ast_014 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_014[0])),
            expression = BinaryExpressionAST(
                left = LiteralAST(literal = Content(content = "2", token = tokens_014[4])),
                operation = Content(content = "/", token = tokens_014[6]),
                right = LiteralAST(literal = Content(content = "3", token = tokens_014[8]))
            )
        ),
    )
)

val ast_015 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_015[0])),
            expression = IdentifierAST(identifier = Content(content = "b", token = tokens_016[4]))
        )
    )
)

val ast_016 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_016[0])),
            expression = BinaryExpressionAST(
                left = IdentifierAST(identifier = Content(content = "b", token = tokens_016[4])),
                operation = Content(content = "+", token = tokens_016[6]),
                right = IdentifierAST(identifier = Content(content = "c", token = tokens_016[8]))
            )
        ),
    )
)

// h
val ast_017 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_016[0])),
            expression = BinaryExpressionAST(
                left = IdentifierAST(identifier = Content(content = "b", token = tokens_016[4])),
                operation = Content(content = "+", token = tokens_016[6]),
                right = IdentifierAST(identifier = Content(content = "c", token = tokens_016[8]))
            )
        ),
    )
)

val ast_018 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_011[0])),
            expression = BinaryExpressionAST(
                left = LiteralAST(literal = Content(content = "2", token = tokens_011[4])),
                operation = Content(content = "+", token = tokens_011[6]),
                right = LiteralAST(literal = Content(content = "3", token = tokens_011[8]))
            )
        ),
    )
)

// j
val ast_019 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_016[0])),
            expression = BinaryExpressionAST(
                left = IdentifierAST(identifier = Content(content = "b", token = tokens_016[4])),
                operation = Content(content = "+", token = tokens_016[6]),
                right = IdentifierAST(identifier = Content(content = "c", token = tokens_016[8]))
            )
        ),
    )
)

// h
val ast_020 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_016[0])),
            expression = BinaryExpressionAST(
                left = IdentifierAST(identifier = Content(content = "b", token = tokens_016[4])),
                operation = Content(content = "+", token = tokens_016[6]),
                right = IdentifierAST(identifier = Content(content = "c", token = tokens_016[8]))
            )
        ),
    )
)
