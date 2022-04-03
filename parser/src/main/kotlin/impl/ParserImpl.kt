package impl

import data.ASTTree
import data.ASTTree.Companion.emptyTree
import impl.enums.TokenTypes
import interfaces.Parser
import interfaces.Syntax
import org.austral.ingsis.printscript.common.Token
import org.austral.ingsis.printscript.common.TokenConsumer
import org.austral.ingsis.printscript.parser.TokenIterator

class ParserImpl : Parser {

    private var syntaxes: List<Syntax> = emptyList()

    init {
        // TODO: add all syntaxes here
    }

    override fun parse(source: String, tokens: List<Token>): ASTTree {
        val tokenIterator = TokenIterator.create(source, tokens)
        val tokenConsumer = TokenConsumerImpl(tokenIterator)

        return buildTree(emptyTree(), tokenConsumer)
    }

    private fun buildTree(tree: ASTTree, consumer: TokenConsumer): ASTTree {
        if (consumer.peek(TokenTypes.EOF) != null) return tree
        else return parseStatement(consumer)
    }

    private fun parseStatement(consumer: TokenConsumer): ASTTree {
        while (consumer.peek(TokenTypes.SEMICOLON) == null) {
            println(consumer.current())
            consumer.consume(consumer.current().type)
        }
        return emptyTree()
    }
}
