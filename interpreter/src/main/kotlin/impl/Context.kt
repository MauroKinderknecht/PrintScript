package impl

import exception.InterpreterException

class Context {

    private var environment: Map<String, ContextElement> = emptyMap<String, ContextElement>().toMutableMap()

    fun read(variable: String): Any {
        return environment[variable]?.value ?: throw InterpreterException("Variable is not initialized")
    }

    fun write(variable: String, expression: Any) {
        val element = environment[variable] ?: throw InterpreterException("Variable is not initialized")
        element.update(expression)
    }

    fun create(variable: String, type: String) {
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
