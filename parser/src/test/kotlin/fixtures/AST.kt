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
            expression = LiteralAST(literal = Content(content = "This is a test!", token = tokens_002[4]))
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
            expression = LiteralAST(literal = Content(content = "This is a test!", token = tokens_004[9]))
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
        VoidFunctionAST(function = Content(content = "println", tokens_009[0]), LiteralAST(literal = Content(content = "This is a test!", token = tokens_008[2])))
    )
)

val ast_009 = ProgramAST(
    children = listOf(
        VoidFunctionAST(function = Content(content = "println", tokens_009[0]), LiteralAST(literal = Content(content = "1.123", token = tokens_009[2])))
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
            expression = LiteralAST(literal = Content(content = "Hello", token = tokens_010[11]))
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

val ast_017 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_017[0])),
            expression = BinaryExpressionAST(
                left = BinaryExpressionAST(
                    left = LiteralAST(literal = Content(content = "2", token = tokens_017[5])),
                    operation = Content(content = "+", token = tokens_017[7]),
                    right = LiteralAST(literal = Content(content = "3", token = tokens_017[9]))
                ),
                operation = Content(content = "*", token = tokens_017[12]),
                right = IdentifierAST(identifier = Content(content = "b", token = tokens_017[14]))
            )
        ),
    )
)

val ast_018 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_018[0])),
            expression = BinaryExpressionAST(
                left = LiteralAST(literal = Content(content = "2", token = tokens_018[5])),
                operation = Content(content = "+", token = tokens_018[7]),
                right = LiteralAST(literal = Content(content = "3", token = tokens_018[9]))
            )
        ),
    )
)

val ast_019 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_019[0])),
            expression = BinaryExpressionAST(
                left = BinaryExpressionAST(
                    left = LiteralAST(literal = Content(content = "2", token = tokens_019[5])),
                    operation = Content(content = "+", token = tokens_019[7]),
                    right = LiteralAST(literal = Content(content = "3", token = tokens_019[9]))
                ),
                operation = Content(content = "*", token = tokens_019[12]),
                right = BinaryExpressionAST(
                    left = LiteralAST(literal = Content(content = "3", token = tokens_019[15])),
                    operation = Content(content = "*", token = tokens_019[17]),
                    right = LiteralAST(literal = Content(content = "5", token = tokens_019[19]))
                )
            )
        ),
    )
)

val ast_020 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_020[0])),
            expression = BinaryExpressionAST(
                left = IdentifierAST(identifier = Content(content = "b", token = tokens_020[4])),
                operation = Content(content = "-", token = tokens_020[6]),
                right = BinaryExpressionAST(
                    left = LiteralAST(literal = Content(content = "3", token = tokens_020[9])),
                    operation = Content(content = "/", token = tokens_020[11]),
                    right = LiteralAST(literal = Content(content = "1", token = tokens_020[13]))
                )
            )
        ),
    )
)

val ast_021 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_021[0])),
            expression = BinaryExpressionAST(
                left = LiteralAST(Content(content = "3", token = tokens_021[4])),
                operation = Content(content = "+", token = tokens_021[6]),
                right = BinaryExpressionAST(
                    left = BinaryExpressionAST(
                        left = LiteralAST(literal = Content(content = "1", token = tokens_021[8])),
                        operation = Content(content = "*", token = tokens_021[10]),
                        right = LiteralAST(literal = Content(content = "3", token = tokens_021[12]))
                    ),
                    operation = Content(content = "-", token = tokens_021[14]),
                    right = BinaryExpressionAST(
                        left = LiteralAST(literal = Content(content = "3", token = tokens_021[16])),
                        operation = Content(content = "/", token = tokens_021[18]),
                        right = LiteralAST(literal = Content(content = "2", token = tokens_021[20]))
                    )
                )
            )
        ),
    )
)

val ast_022 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_022[0])),
            expression = BinaryExpressionAST(
                left = BinaryExpressionAST(
                    left = LiteralAST(literal = Content(content = "5", token = tokens_022[4])),
                    operation = Content(content = "*", token = tokens_022[6]),
                    right = LiteralAST(literal = Content(content = "5", token = tokens_022[8]))
                ),
                operation = Content(content = "-", token = tokens_022[10]),
                right = BinaryExpressionAST(
                    left = BinaryExpressionAST(
                        left = LiteralAST(literal = Content(content = "8", token = tokens_022[12])),
                        operation = Content(content = "/", token = tokens_022[14]),
                        right = LiteralAST(literal = Content(content = "4", token = tokens_022[16]))
                    ),
                    operation = Content(content = "+", token = tokens_022[18]),
                    right = LiteralAST(literal = Content(content = "2", token = tokens_022[20]))
                )
            )
        )
    )
)

val ast_024 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = VariableAST(variable = Content(content = "a", token = tokens_024[0])),
            expression = BinaryExpressionAST(
                left = LiteralAST(literal = Content("'Test string concatenation'", token = tokens_024[4])),
                operation = Content(content = "+", token = tokens_024[6]),
                right = LiteralAST(literal = Content(content = "23", token = tokens_024[8]))
            )
        ),
    )
)

val ast_025 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = DeclarationAST(
                variable = Content(content = "const", token = tokens_025[0]),
                identifier = Content(content = "a", token = tokens_025[2]),
                type = Content(content = "Number", token = tokens_025[5])
            ),
            expression = LiteralAST(literal = Content("20", token = tokens_025[9])),
        ),
    )
)

val ast_026 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = DeclarationAST(
                variable = Content(content = "let", token = tokens_026[0]),
                identifier = Content(content = "a", token = tokens_026[2]),
                type = Content(content = "Boolean", token = tokens_026[5])
            ),
            expression = LiteralAST(literal = Content("true", token = tokens_026[9])),
        ),
    )
)

val ast_027 = ProgramAST(
    children = listOf(
        IfAST(
            condition = LiteralAST(literal = Content("true", token = tokens_027[3])),
            truthy = BlockAST(
                statements = listOf(
                    VoidFunctionAST(
                        function = Content(content = "println", token = tokens_027[8]),
                        expression = LiteralAST(literal = Content("20", token = tokens_027[10])),
                    )
                )
            )
        )
    )
)

val ast_028 = ProgramAST(
    children = listOf(
        IfAST(
            condition = LiteralAST(literal = Content("true", token = tokens_028[3])),
            truthy = BlockAST(
                statements = listOf(
                    VoidFunctionAST(
                        function = Content(content = "println", token = tokens_028[10]),
                        expression = LiteralAST(literal = Content("20", token = tokens_028[12])),
                    )
                )
            )
        )
    )
)

val ast_029 = ProgramAST(
    children = listOf(
        IfAST(
            condition = LiteralAST(literal = Content("true", token = tokens_029[3])),
            truthy = BlockAST(
                statements = listOf(
                    VoidFunctionAST(
                        function = Content(content = "println", token = tokens_029[10]),
                        expression = LiteralAST(literal = Content("30", token = tokens_029[12])),
                    ),
                    VoidFunctionAST(
                        function = Content(content = "println", token = tokens_029[18]),
                        expression = LiteralAST(literal = Content("'Hello'", token = tokens_029[20])),
                    )
                )
            )
        )
    )
)

val ast_030 = ProgramAST(
    children = listOf(
        IfElseAST(
            condition = LiteralAST(literal = Content("false", token = tokens_030[3])),
            truthy = BlockAST(
                statements = listOf(
                    VoidFunctionAST(
                        function = Content(content = "println", token = tokens_030[8]),
                        expression = LiteralAST(literal = Content("20", token = tokens_030[10])),
                    ),
                )
            ),
            falsy = BlockAST(
                statements = listOf(
                    VoidFunctionAST(
                        function = Content(content = "println", token = tokens_030[19]),
                        expression = LiteralAST(literal = Content("10", token = tokens_030[21])),
                    ),
                )
            )
        )
    )
)

val ast_031 = ProgramAST(
    children = listOf(
        AssignationAST(
            lhs = DeclarationAST(
                variable = Content(content = "let", token = tokens_031[0]),
                identifier = Content(content = "a", token = tokens_031[2]),
                type = Content(content = "String", token = tokens_031[5])
            ),
            expression = FunctionCallAST(
                function = Content("readInput", token = tokens_031[9]),
                arguments = listOf(
                    LiteralAST(literal = Content(content = "'Type your name'", token = tokens_031[11]))
                )
            ),
        ),
    )
)
