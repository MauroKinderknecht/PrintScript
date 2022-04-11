package impl

import data.AST
import data.ProgramAST
import enums.SyntaxElements
import exception.ParserException
import interfaces.Parser
import org.austral.ingsis.printscript.common.Token
import org.austral.ingsis.printscript.common.TokenConsumer
import org.austral.ingsis.printscript.parser.Content
import org.austral.ingsis.printscript.parser.TokenIterator

class ParserImpl : Parser {
    private val matcher: StatementMatcher = StatementMatcher()

    override fun parse(source: String, tokens: List<Token>): AST {
        val tokenIterator = TokenIterator.create(source, tokens)
        val tokenConsumer = TokenConsumerImpl(tokenIterator)

        // head node of tree
        val tree = ProgramAST()
        return buildTree(tree, matcher, tokenConsumer)
    }

    private fun buildTree(tree: ProgramAST, matcher: StatementMatcher, consumer: TokenConsumer): AST {
        if (consumer.peekAny(*SyntaxElements.EOF.get()) != null) return tree
        val statement = parseStatement(matcher, consumer) ?: throw ParserException("Se murio el parser")
        tree.add(statement)
        return buildTree(tree, matcher, consumer)
    }

    private fun parseStatement(matcher: StatementMatcher, consumer: TokenConsumer): AST? {
        // consume next statement and filter not useful tokens
        val content = emptyList<Content<String>>().toMutableList()
        while (consumer.peekAny(*SyntaxElements.END.get(), *SyntaxElements.EOF.get()) == null) {
            if (consumer.peekAny(*SyntaxElements.NOTUSEFUL.get()) != null) {
                consumer.consumeAny(*SyntaxElements.NOTUSEFUL.get())
                continue
            }
            content += consumer.consume(consumer.current().type)
        }
        if (consumer.peekAny(*SyntaxElements.END.get()) != null) consumer.consume(consumer.current().type)
        // match with declared statements
        return matcher.match(content)
    }
}
