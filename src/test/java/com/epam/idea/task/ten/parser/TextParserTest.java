package com.epam.idea.task.ten.parser;

import com.epam.idea.task.ten.composite.Component;
import com.epam.idea.task.ten.composite.Composite;
import com.epam.idea.task.ten.exception.ComponentException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;

public class TextParserTest {
    private static final String TEXT_WITH_ONE_PARAGRAPH = "\tFirst paragraph.";
    private static final String TEXT_WITH_TWO_PARAGRAPHS = "\tFirst paragraph.   \tSecond paragraph.";

    private static final int ONE_ELEMENT = 1;
    private static final int TWO_ELEMENTS = 2;


    @Test
    public void testParserShouldReturnTextCompositeWithOneParagraph() throws ComponentException {
        Parser paragraphParser = mock(ParagraphParser.class);
        TextParser textParser = new TextParser();
        textParser.setSuccessor(paragraphParser);

        Component textComposite = textParser.parse(TEXT_WITH_ONE_PARAGRAPH);
        List<Component> paragraphComposites = textComposite.getChildren();

        Assert.assertEquals(ONE_ELEMENT, paragraphComposites.size());
    }

    @Test
    public void testParserShouldReturnTextCompositeWithTwoParagraphs() throws ComponentException {
        Parser paragraphParser = mock(ParagraphParser.class);
        TextParser textParser = new TextParser();
        textParser.setSuccessor(paragraphParser);

        Component textComposite = textParser.parse(TEXT_WITH_TWO_PARAGRAPHS);
        List<Component> paragraphComposites = textComposite.getChildren();

        Assert.assertEquals(TWO_ELEMENTS, paragraphComposites.size());
    }
}
