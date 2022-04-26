package impl

import enums.MenuOption
import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.Files

class CLI {

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
                MenuOption.FILE -> readFromFile(false)
                MenuOption.VALIDATE_FILE -> readFromFile(true)
                MenuOption.EXIT -> return
            }
        }
    }

    private fun menu(): MenuOption {
        println(
            "Select an option: \n" +
                "1. REPL \n" +
                "2. Interpret from File \n" +
                "3. Validate from File \n" +
                "4. Exit"
        )

        return try {
            when (val option = readln().toInt()) {
                1 -> MenuOption.REPL
                2 -> MenuOption.FILE
                3 -> MenuOption.VALIDATE_FILE
                4 -> MenuOption.EXIT
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
        println("Select an version:")
        val version = readln()

        val printScript = PrintScript(::println, ::println, ::readln, version, false)

        while (true) {
            print("PrintScript > ")
            printScript.interpret(readln())
        }
    }

    private fun readFromFile(validate: Boolean) {
        println("Select an version:")
        val version = readln()
        println("Insert the path of the file:")
        val path = readln()

        val srcFile = File(path)
        val src = Files.readString(srcFile.toPath(), StandardCharsets.US_ASCII)

        val printScript = PrintScript(::println, ::println, ::readln, version, true)
        if (validate) printScript.validate(src) else printScript.interpret(src)
    }
}

fun main() = CLI().run()
