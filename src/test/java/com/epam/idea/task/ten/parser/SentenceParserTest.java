package com.epam.idea.task.ten.parser;

import com.epam.idea.task.ten.composite.Component;
import com.epam.idea.task.ten.composite.Lexeme;
import com.epam.idea.task.ten.exception.ComponentException;
import org.junit.Assert;
import org.junit.Test;

public class SentenceParserTest {
    private static final String WORD = "Hello";
    private static final String EXPRESSION = "55+5*";

    @Test
    public void testParseShouldParseWordType() throws ComponentException {
        Parser parser = new SentenceParser();
        Component wordComponent = parser.parse(WORD);

        Lexeme wordLexeme = (Lexeme) wordComponent;

        Assert.assertFalse(wordLexeme.isExpression());
    }

    @Test
    public void testParseShouldParseExpressionType() throws ComponentException {
        Parser parser = new SentenceParser();
        Component wordComponent = parser.parse(EXPRESSION);

        Lexeme wordLexeme = (Lexeme) wordComponent;

        Assert.assertTrue(wordLexeme.isExpression());
    }
}

