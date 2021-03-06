package fixtures

import data.*
import org.austral.ingsis.printscript.parser.Content

val ast_001 = ProgramAST(listOf())

val ast_002 = ProgramAST(
    children = listOf(
        DeclarationAST(
            variable = Content(content = "let", token = tokens_002[0]),
            identifier = Content(content = "a", token = tokens_002[2]),
            type = Content(content = "String", token = tokens_002[5])
        )
    )
)

val ast_003 = ProgramAST(
    children = listOf(
        DeclarationAST(
            variable = Content(content = "let", token = tokens_002[0]),
            identifier = Content(content = "a", token = tokens_002[2]),
            type = Content(content = "String", token = tokens_002[5])
        ),
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_003[0])),
            expression = LiteralAST(literal = Content(content = "\"This is a test!\"", token = tokens_003[4]))
        )
    )
)

val ast_004 = ProgramAST(
    children = listOf(
        DeclarationAST(
            variable = Content(content = "let", token = tokens_002[0]),
            identifier = Content(content = "a", token = tokens_002[2]),
            type = Content(content = "String", token = tokens_002[5])
        ),
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_004[0])),
            expression = LiteralAST(literal = Content(content = "\'This is a test!\'", token = tokens_004[4]))
        )
    )
)

val ast_005 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = DeclarationAST(
                variable = Content(content = "let", token = tokens_005[0]),
                identifier = Content(content = "a", token = tokens_005[2]),
                type = Content(content = "String", token = tokens_005[5])
            ),
            expression = LiteralAST(literal = Content(content = "\"This is a test!\"", token = tokens_005[9]))
        )
    )
)

val ast_006 = ProgramAST(
    children = listOf(
        DeclarationAST(
            variable = Content(content = "let", token = tokens_006[0]),
            identifier = Content(content = "a", token = tokens_006[2]),
            type = Content(content = "Number", token = tokens_006[5])
        )
    )
)

val ast_007 = ProgramAST(
    children = listOf(
        DeclarationAST(
            variable = Content(content = "let", token = tokens_006[0]),
            identifier = Content(content = "a", token = tokens_006[2]),
            type = Content(content = "Number", token = tokens_006[5])
        ),
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_007[0])),
            expression = LiteralAST(literal = Content(content = "2", token = tokens_007[4]))
        )
    )
)

val ast_008 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = DeclarationAST(
                variable = Content(content = "let", token = tokens_008[0]),
                identifier = Content(content = "a", token = tokens_008[2]),
                type = Content(content = "Number", token = tokens_008[5])
            ),
            expression = LiteralAST(literal = Content(content = "2.123", token = tokens_008[9]))
        )
    )
)

val ast_009 = ProgramAST(
    children = listOf(
        VoidFunctionAST(function = Content(content = "println", tokens_009[0]), LiteralAST(literal = Content(content = "\"This is a test!\"", token = tokens_009[2])))
    )
)

val ast_010 = ProgramAST(
    children = listOf(
        VoidFunctionAST(function = Content(content = "println", tokens_010[0]), LiteralAST(literal = Content(content = "1.123", token = tokens_010[2])))
    )
)

val ast_011 = ProgramAST(
    children = listOf(
        DeclarationAST(
            variable = Content(content = "let", token = tokens_006[0]),
            identifier = Content(content = "a", token = tokens_006[2]),
            type = Content(content = "Number", token = tokens_006[5])
        ),
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_011[0])),
            expression = LiteralAST(literal = Content(content = "1.123", token = tokens_011[4]))
        ),
        DeclarationAST(
            variable = Content(content = "let", token = tokens_005[0]),
            identifier = Content(content = "b", token = tokens_005[2]),
            type = Content(content = "String", token = tokens_005[5])
        ),
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "b", token = tokens_011[7])),
            expression = LiteralAST(literal = Content(content = "\"Hello\"", token = tokens_011[11]))
        ),
    )
)

val ast_012 = ProgramAST(
    children = listOf(
        DeclarationAST(
            variable = Content(content = "let", token = tokens_006[0]),
            identifier = Content(content = "a", token = tokens_006[2]),
            type = Content(content = "Number", token = tokens_006[5])
        ),
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_012[0])),
            expression = BinaryExpressionAST(
                left = LiteralAST(literal = Content(content = "2", token = tokens_012[4])),
                operation = Content(content = "+", token = tokens_012[6]),
                right = LiteralAST(literal = Content(content = "3", token = tokens_012[8]))
            )
        ),
    )
)

val ast_013 = ProgramAST(
    children = listOf(
        DeclarationAST(
            variable = Content(content = "let", token = tokens_006[0]),
            identifier = Content(content = "a", token = tokens_006[2]),
            type = Content(content = "Number", token = tokens_006[5])
        ),
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_013[0])),
            expression = BinaryExpressionAST(
                left = LiteralAST(literal = Content(content = "2", token = tokens_013[4])),
                operation = Content(content = "-", token = tokens_013[6]),
                right = LiteralAST(literal = Content(content = "3", token = tokens_013[8]))
            )
        ),
    )
)

val ast_014 = ProgramAST(
    children = listOf(
        DeclarationAST(
            variable = Content(content = "let", token = tokens_006[0]),
            identifier = Content(content = "a", token = tokens_006[2]),
            type = Content(content = "Number", token = tokens_006[5])
        ),
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_014[0])),
            expression = BinaryExpressionAST(
                left = LiteralAST(literal = Content(content = "2", token = tokens_014[4])),
                operation = Content(content = "*", token = tokens_014[6]),
                right = LiteralAST(literal = Content(content = "3", token = tokens_014[8]))
            )
        ),
    )
)

val ast_015 = ProgramAST(
    children = listOf(
        DeclarationAST(
            variable = Content(content = "let", token = tokens_006[0]),
            identifier = Content(content = "a", token = tokens_006[2]),
            type = Content(content = "Number", token = tokens_006[5])
        ),
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_016[0])),
            expression = BinaryExpressionAST(
                left = LiteralAST(literal = Content(content = "2", token = tokens_015[4])),
                operation = Content(content = "/", token = tokens_015[6]),
                right = LiteralAST(literal = Content(content = "3", token = tokens_015[8]))
            )
        ),
    )
)

val ast_016 = ProgramAST(
    children = listOf(
        DeclarationAST(
            variable = Content(content = "let", token = tokens_006[0]),
            identifier = Content(content = "a", token = tokens_006[2]),
            type = Content(content = "Number", token = tokens_006[5])
        ),
        AssignationAST(
            lhs = DeclarationAST(
                variable = Content(content = "let", token = tokens_008[0]),
                identifier = Content(content = "b", token = tokens_008[2]),
                type = Content(content = "Number", token = tokens_008[5])
            ),
            expression = LiteralAST(literal = Content(content = "2", token = tokens_008[9]))
        ),
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_016[0])),
            expression = IdentifierAST(identifier = Content(content = "b", token = tokens_016[4]))
        )
    )
)

val ast_017 = ProgramAST(
    children = listOf(
        DeclarationAST(
            variable = Content(content = "let", token = tokens_006[0]),
            identifier = Content(content = "a", token = tokens_006[2]),
            type = Content(content = "Number", token = tokens_006[5])
        ),
        AssignationAST(
            lhs = DeclarationAST(
                variable = Content(content = "let", token = tokens_008[0]),
                identifier = Content(content = "b", token = tokens_008[2]),
                type = Content(content = "Number", token = tokens_008[5])
            ),
            expression = LiteralAST(literal = Content(content = "2", token = tokens_008[9]))
        ),
        AssignationAST(
            lhs = DeclarationAST(
                variable = Content(content = "let", token = tokens_008[0]),
                identifier = Content(content = "c", token = tokens_008[2]),
                type = Content(content = "Number", token = tokens_008[5])
            ),
            expression = LiteralAST(literal = Content(content = "5", token = tokens_008[9]))
        ),
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_017[0])),
            expression = BinaryExpressionAST(
                left = IdentifierAST(identifier = Content(content = "b", token = tokens_017[4])),
                operation = Content(content = "+", token = tokens_017[6]),
                right = IdentifierAST(identifier = Content(content = "c", token = tokens_017[8]))
            )
        ),
    )
)

val ast_018 = ProgramAST(
    children = listOf(
        DeclarationAST(
            variable = Content(content = "let", token = tokens_006[0]),
            identifier = Content(content = "a", token = tokens_006[2]),
            type = Content(content = "Number", token = tokens_006[5])
        ),
        AssignationAST(
            lhs = DeclarationAST(
                variable = Content(content = "let", token = tokens_008[0]),
                identifier = Content(content = "b", token = tokens_008[2]),
                type = Content(content = "Number", token = tokens_008[5])
            ),
            expression = LiteralAST(literal = Content(content = "2", token = tokens_008[9]))
        ),
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_018[0])),
            expression = BinaryExpressionAST(
                left = BinaryExpressionAST(
                    left = LiteralAST(literal = Content(content = "2", token = tokens_018[5])),
                    operation = Content(content = "+", token = tokens_018[7]),
                    right = LiteralAST(literal = Content(content = "3", token = tokens_018[9]))
                ),
                operation = Content(content = "*", token = tokens_018[12]),
                right = IdentifierAST(identifier = Content(content = "b", token = tokens_018[14]))
            )
        ),
    )
)

val ast_019 = ProgramAST(
    children = listOf(
        DeclarationAST(
            variable = Content(content = "let", token = tokens_006[0]),
            identifier = Content(content = "a", token = tokens_006[2]),
            type = Content(content = "Number", token = tokens_006[5])
        ),
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_019[0])),
            expression = BinaryExpressionAST(
                left = LiteralAST(literal = Content(content = "2", token = tokens_019[5])),
                operation = Content(content = "+", token = tokens_019[7]),
                right = LiteralAST(literal = Content(content = "3", token = tokens_019[9]))
            )
        ),
    )
)

val ast_020 = ProgramAST(
    children = listOf(
        DeclarationAST(
            variable = Content(content = "let", token = tokens_006[0]),
            identifier = Content(content = "a", token = tokens_006[2]),
            type = Content(content = "Number", token = tokens_006[5])
        ),
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_020[0])),
            expression = BinaryExpressionAST(
                left = BinaryExpressionAST(
                    left = LiteralAST(literal = Content(content = "2", token = tokens_020[5])),
                    operation = Content(content = "+", token = tokens_020[7]),
                    right = LiteralAST(literal = Content(content = "3", token = tokens_020[9]))
                ),
                operation = Content(content = "*", token = tokens_020[12]),
                right = BinaryExpressionAST(
                    left = LiteralAST(literal = Content(content = "3", token = tokens_020[15])),
                    operation = Content(content = "*", token = tokens_020[17]),
                    right = LiteralAST(literal = Content(content = "5", token = tokens_020[19]))
                )
            )
        ),
    )
)

val ast_021 = ProgramAST(
    children = listOf(
        DeclarationAST(
            variable = Content(content = "let", token = tokens_006[0]),
            identifier = Content(content = "a", token = tokens_006[2]),
            type = Content(content = "Number", token = tokens_006[5])
        ),
        AssignationAST(
            lhs = DeclarationAST(
                variable = Content(content = "let", token = tokens_008[0]),
                identifier = Content(content = "b", token = tokens_008[2]),
                type = Content(content = "Number", token = tokens_008[5])
            ),
            expression = LiteralAST(literal = Content(content = "5", token = tokens_008[9]))
        ),
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_021[0])),
            expression = BinaryExpressionAST(
                left = IdentifierAST(identifier = Content(content = "b", token = tokens_021[4])),
                operation = Content(content = "-", token = tokens_021[6]),
                right = BinaryExpressionAST(
                    left = LiteralAST(literal = Content(content = "3", token = tokens_021[9])),
                    operation = Content(content = "/", token = tokens_021[11]),
                    right = LiteralAST(literal = Content(content = "1", token = tokens_021[13]))
                )
            )
        ),
    )
)

val ast_022 = ProgramAST(
    children = listOf(
        DeclarationAST(
            variable = Content(content = "let", token = tokens_006[0]),
            identifier = Content(content = "a", token = tokens_006[2]),
            type = Content(content = "Number", token = tokens_006[5])
        ),
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_022[0])),
            expression = BinaryExpressionAST(
                left = LiteralAST(Content(content = "3", token = tokens_022[4])),
                operation = Content(content = "+", token = tokens_022[6]),
                right = BinaryExpressionAST(
                    left = BinaryExpressionAST(
                        left = LiteralAST(literal = Content(content = "1", token = tokens_022[8])),
                        operation = Content(content = "*", token = tokens_022[10]),
                        right = LiteralAST(literal = Content(content = "3", token = tokens_022[12]))
                    ),
                    operation = Content(content = "-", token = tokens_022[14]),
                    right = BinaryExpressionAST(
                        left = LiteralAST(literal = Content(content = "3", token = tokens_022[16])),
                        operation = Content(content = "/", token = tokens_022[18]),
                        right = LiteralAST(literal = Content(content = "2", token = tokens_022[20]))
                    )
                )
            )
        ),
    )
)

val ast_023 = AssignationAST(
    lhs = VariableAST(variable = Content(content = "a", token = tokens_003[0])),
    expression = LiteralAST(literal = Content(content = "\"This is a test!\"", token = tokens_003[4]))
)

val ast_024 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_004[0])),
            expression = LiteralAST(literal = Content(content = "\'This is a test!\'", token = tokens_004[4]))
        )
    )
)

val ast_025 = ProgramAST(
    children = listOf(
        DeclarationAST(
            variable = Content(content = "let", token = tokens_006[0]),
            identifier = Content(content = "a", token = tokens_006[2]),
            type = Content(content = "Number", token = tokens_006[5])
        ),
        DeclarationAST(
            variable = Content(content = "let", token = tokens_005[0]),
            identifier = Content(content = "a", token = tokens_005[2]),
            type = Content(content = "String", token = tokens_005[5])
        ),
    )
)
