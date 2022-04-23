import java.util.function.Consumer

class TestConsumer : Consumer<String> {

    private val history: MutableList<String> = emptyList<String>().toMutableList()

    override fun accept(t: String) {
        history.add(t)
    }

    override fun toString(): String {
        return history.toString()
    }
}
