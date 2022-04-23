package impl

import exception.InterpreterException
import interfaces.ContextProvider

class Context : ContextProvider {

    private var environment: Map<String, ContextElement> = emptyMap<String, ContextElement>().toMutableMap()

    override fun read(variable: String): Any {
        return environment[variable]?.value
            ?: throw InterpreterException("INTERPRETER ERROR: Variable $variable is not initialized")
    }

    override fun write(variable: String, value: Any) {
        val element = environment[variable]
            ?: throw InterpreterException("INTERPRETER ERROR: Variable $variable is not initialized")
        element.update(value)
    }

    override fun create(variable: String, type: String) {
        environment = environment + Pair(variable, ContextElement(type = type))
    }

    companion object {
        fun emptyContext() = Context()
    }
}

data class ContextElement(var value: Any? = null, val type: String) {
    fun update(value: Any) {
        this.value = value
    }
}
