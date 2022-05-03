package impl

import data.AST
import data.ProgramAST
import enums.SyntaxElements
import enums.TokenTypes
import exception.ParserException
import interfaces.Parser
import org.austral.ingsis.printscript.common.Token
import org.austral.ingsis.printscript.common.TokenConsumer
import org.austral.ingsis.printscript.parser.Content
import org.austral.ingsis.printscript.parser.TokenIterator

class ParserImpl(private val matcher: StatementMatcher) : Parser {

    override fun parse(source: String, tokens: List<Token>): AST {
        val tokenIterator = TokenIterator.create(source, tokens)
        val tokenConsumer = TokenConsumer(tokenIterator)
        // head node of tree
        val tree = ProgramAST()
        return buildTree(tree, matcher, tokenConsumer)
    }

    private fun buildTree(tree: ProgramAST, matcher: StatementMatcher, consumer: TokenConsumer): AST {
        if (consumer.peekAny(*SyntaxElements.EOF.get()) != null) return tree
        if (consumer.peekAny(*SyntaxElements.NOTUSEFUL.get()) != null) {
            consumer.consume(consumer.current().type)
            return buildTree(tree, matcher, consumer)
        }
        val statement = parseStatement(matcher, consumer)
        tree.add(statement)
        return buildTree(tree, matcher, consumer)
    }

    private fun parseStatement(matcher: StatementMatcher, consumer: TokenConsumer): AST {
        // consume next statement and filter not useful tokens
        val content = getContent(consumer).toMutableList()
        if (consumer.peekAny(*SyntaxElements.END.get()) != null) consumer.consume(consumer.current().type)
        else if (consumer.peekAny(TokenTypes.CLOSEBRACE) != null) {
            content += consumer.consume(consumer.current().type)
            if (consumer.peekAny(TokenTypes.ELSE) != null) content += getContent(consumer)
        }
        else throw ParserException("Missing semicolon", content[content.size - 1].token.range)
        // match with declared statements
        return matcher.match(content)
            ?: throw ParserException("Could not match statement ${content.map { c -> c.content }.reduce{str, c -> "$str $c" }}", content[0].token.range)
    }

    private fun getContent(consumer: TokenConsumer): List<Content<String>> {
        val content = emptyList<Content<String>>().toMutableList()
        var braceCount = 0

        while (
            consumer.peekAny(*SyntaxElements.EOF.get()) == null &&
            (consumer.peekAny(*SyntaxElements.END.get()) == null || braceCount != 0) &&
            (consumer.peekAny(TokenTypes.CLOSEBRACE) == null || braceCount != 1)
        ) {
            if (consumer.peekAny(*SyntaxElements.NOTUSEFUL.get()) != null) {
                consumer.consumeAny(consumer.current().type)
                continue
            }

            if (consumer.peekAny(TokenTypes.OPENBRACE) != null) braceCount++
            else if (consumer.peekAny(TokenTypes.CLOSEBRACE) != null) braceCount--
            content += consumer.consume(consumer.current().type)
        }

        return content
    }
}
