package impl

import exception.InterpreterException
import interfaces.ContextProvider
import org.austral.ingsis.printscript.common.TokenType

class ContextProviderImpl : ContextProvider {

    private var environment: Map<String, ContextElement> = emptyMap<String, ContextElement>().toMutableMap()

    override fun read(variable: String): Pair<TokenType, Any> {
        val result = environment[variable] ?: throw InterpreterException("Variable $variable does not exists")
        if (result.value != null) return Pair(result.type, result.value!!)
        else throw InterpreterException("Variable $variable is not initialized", null)
    }

    override fun write(variable: String, type: TokenType, value: Any): String {
        val element = environment[variable]
            ?: throw InterpreterException("Variable $variable is not initialized")
        if (element.value != null && !element.modifiable) throw InterpreterException("Constant $variable cannot be reasigned")
        if (element.type != type) throw InterpreterException("Type mismatch $value is not of type ${element.type}")
        element.update(value)
        return variable
    }

    override fun create(variable: String, type: TokenType, modifiable: Boolean): String {
        if (environment[variable] != null) throw InterpreterException("Variable $variable is already declared")
        environment = environment + Pair(variable, ContextElement(type = type, modifiable = modifiable))
        return variable
    }

    override fun isEmpty(): Boolean = environment.isEmpty()

    override fun toString(): String {
        return environment.toString()
    }

    data class ContextElement(var value: Any? = null, val type: TokenType, val modifiable: Boolean) {
        fun update(value: Any) {
            this.value = value
        }
    }
}
