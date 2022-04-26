package fixtures

import enums.TokenTypes
import impl.ContextProviderImpl.ContextElement

val context_002 = mapOf("a" to ContextElement(value = null, type = TokenTypes.STRING, modifiable = true))

val context_003 = mapOf("a" to ContextElement(value = "This is a test!", type = TokenTypes.STRING, modifiable = true))

val context_004 = mapOf("a" to ContextElement(value = "This is a test!", type = TokenTypes.STRING, modifiable = true))

val context_005 = mapOf("a" to ContextElement(value = "This is a test!", type = TokenTypes.STRING, modifiable = true))

val context_006 = mapOf("a" to ContextElement(value = null, type = TokenTypes.NUMBER, modifiable = true))

val context_007 = mapOf("a" to ContextElement(value = 2, type = TokenTypes.NUMBER, modifiable = true))

val context_008 = mapOf("a" to ContextElement(value = 2.123, type = TokenTypes.NUMBER, modifiable = true))

val context_009 = listOf("This is a test!")

val context_010 = listOf(1.123)

val context_011 = mapOf(
    "a" to ContextElement(value = 1.123, type = TokenTypes.NUMBER, modifiable = true),
    "b" to ContextElement(value = "Hello", type = TokenTypes.STRING, modifiable = true)
)

val context_012 = mapOf("a" to ContextElement(value = 5, type = TokenTypes.NUMBER, modifiable = true))

val context_013 = mapOf("a" to ContextElement(value = -1, type = TokenTypes.NUMBER, modifiable = true))

val context_014 = mapOf("a" to ContextElement(value = 6, type = TokenTypes.NUMBER, modifiable = true))

val context_015 = mapOf("a" to ContextElement(value = 0.6666666666666666, type = TokenTypes.NUMBER, modifiable = true))

val context_016 = mapOf(
    "a" to ContextElement(value = 2, type = TokenTypes.NUMBER, modifiable = true),
    "b" to ContextElement(value = 2, type = TokenTypes.NUMBER, modifiable = true)
)

val context_017 = mapOf(
    "a" to ContextElement(value = 7, type = TokenTypes.NUMBER, modifiable = true),
    "b" to ContextElement(value = 2, type = TokenTypes.NUMBER, modifiable = true),
    "c" to ContextElement(value = 5, type = TokenTypes.NUMBER, modifiable = true)
)

val context_018 = mapOf(
    "a" to ContextElement(value = 10, type = TokenTypes.NUMBER, modifiable = true),
    "b" to ContextElement(value = 2, type = TokenTypes.NUMBER, modifiable = true)
)

val context_019 = mapOf("a" to ContextElement(value = 5, type = TokenTypes.NUMBER, modifiable = true))

val context_020 = mapOf("a" to ContextElement(value = 75, type = TokenTypes.NUMBER, modifiable = true))

val context_021 = mapOf(
    "a" to ContextElement(value = 2.0, type = TokenTypes.NUMBER, modifiable = true),
    "b" to ContextElement(value = 5, type = TokenTypes.NUMBER, modifiable = true)
)

val context_022 = mapOf("a" to ContextElement(value = 4.5, type = TokenTypes.NUMBER, modifiable = true))
