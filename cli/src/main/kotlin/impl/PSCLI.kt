package impl

import enums.MenuOption

class CLI {

    private val version = "1.1"
    private val verbose = false

    private val printScript = PrintScript(System.out::println, System.out::println, version, verbose)

    private fun interpret(src: String) = printScript.interpret(src)

    private fun init() {
        println(
            "██████  ██████  ██ ███    ██ ████████ ███████  ██████ ██████  ██ ██████  ████████ \n" +
                "██   ██ ██   ██ ██ ████   ██    ██    ██      ██      ██   ██ ██ ██   ██    ██    \n" +
                "██████  ██████  ██ ██ ██  ██    ██    ███████ ██      ██████  ██ ██████     ██    \n" +
                "██      ██   ██ ██ ██  ██ ██    ██         ██ ██      ██   ██ ██ ██         ██    \n" +
                "██      ██   ██ ██ ██   ████    ██    ███████  ██████ ██   ██ ██ ██         ██    \n" +
                "\n" +
                "_________________________________________________________________________________ \n" +
                "\n"
        )
    }

    fun run() {
        init()
        var exit = false
        while (!exit) {
            when (menu()) {
                MenuOption.REPL -> {
                    repl()
                    exit = true
                }
                MenuOption.FILE -> readFromFile()
                MenuOption.EXIT -> exit = true
            }
        }
    }

    private fun menu(): MenuOption {
        println(
            "Select an option: \n" +
                "1. REPL \n" +
                "2. Read from File \n" +
                "3. Exit \n"
        )

        return try {
            when (val option = readln().toInt()) {
                1 -> MenuOption.REPL
                2 -> MenuOption.FILE
                3 -> MenuOption.EXIT
                else -> {
                    println("Oops, $option is not a valid option. Please enter a valid option.")
                    menu()
                }
            }
        } catch (_: java.lang.NumberFormatException) {
            println("Please enter a number")
            menu()
        }
    }

    private fun repl() {
        while (true) {
            print("PrintScript > ")
            interpret(readln())
        }
    }

    private fun readFromFile() {
        val a = "println('Hello world!')"
        interpret(a)
    }
}

fun main() = CLI().run()
