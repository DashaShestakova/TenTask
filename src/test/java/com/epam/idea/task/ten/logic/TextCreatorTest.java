package com.epam.idea.task.ten.logic;

import com.epam.idea.task.ten.composite.Composite;
import com.epam.idea.task.ten.composite.Lexeme;
import com.epam.idea.task.ten.exception.ComponentException;
import com.epam.idea.task.ten.logic.creator.TextCreator;
import com.epam.idea.task.ten.logic.expression.ExpressionCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.mockito.Mockito.mock;

public class TextCreatorTest {
    private static final Lexeme FIRST_TEST_WORD = Lexeme.word("Good");
    private static final Lexeme SECOND_TEST_WORD = Lexeme.word("morning.");
    private static final Lexeme THIRD_TEST_WORD = Lexeme.word("How");
    private static final Lexeme FOURTH_TEST_WORD = Lexeme.word("are");
    private static final Lexeme FIFTH_TEST_WORD = Lexeme.word("you?");
    private static final Composite FIRST_TEST_SENTENCE = new Composite(Arrays.asList(FIRST_TEST_WORD,SECOND_TEST_WORD));
    private static final Composite SECOND_TEST_SENTENCE = new Composite(Arrays.asList(THIRD_TEST_WORD,FOURTH_TEST_WORD,FIFTH_TEST_WORD));
    private static final Composite FIRST_TEST_PARAGRAPH = new Composite(Arrays.asList(FIRST_TEST_SENTENCE));
    private static final Composite SECOND_TEST_PARAGRAPH = new Composite(Arrays.asList(SECOND_TEST_SENTENCE));
    private static final Composite TEST_COMPOSITE= new Composite(Arrays.asList(FIRST_TEST_PARAGRAPH,SECOND_TEST_PARAGRAPH));
    private static final String EXPECTED_TEXT = "Good morning. How are you?";

    @Test
    public void testCreateTextShouldCreateText() throws ComponentException {
        ExpressionCalculator calculatorMock = mock(ExpressionCalculator.class);
        TextCreator textAssembler = new TextCreator(calculatorMock);

        String actualText = textAssembler.createText(TEST_COMPOSITE);

        Assert.assertEquals(EXPECTED_TEXT,actualText);
    }
}
