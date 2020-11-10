package com.epam.idea.task.ten.parser;

import com.epam.idea.task.ten.composite.Component;
import com.epam.idea.task.ten.composite.Composite;
import com.epam.idea.task.ten.exception.ComponentException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;

public class ParagraphParserTest {
    private static final String PARAGRAPH_WITH_ONE_SENTENCE = "\tFirst sentence.";
    private static final String PARAGRAPH_WITH_TWO_SENTENCES = "\tFirst sentence. Second sentence.";

    private static final int ONE_ELEMENT = 1;
    private static final int TWO_ELEMENTS = 2;


    @Test
    public void testParseShouldParseWhenParagraphIncludeOneSentence() throws ComponentException {
        Parser sentenceParser = mock(SentenceParser.class);
        ParagraphParser paragraphParser = new ParagraphParser();
        paragraphParser.setSuccessor(sentenceParser);

        Component paragraphComposite = paragraphParser.parse(PARAGRAPH_WITH_ONE_SENTENCE);
        List<Component> sentenceComposites = paragraphComposite.getChildren();

        Assert.assertEquals(Composite.class, paragraphComposite.getClass());
        Assert.assertEquals(ONE_ELEMENT, sentenceComposites.size());
    }

    @Test
    public void testParserShouldParseWhenParagraphIncludeTwoSentence() throws ComponentException {
        Parser sentenceParser = mock(ParagraphParser.class);
        ParagraphParser paragraphParser = new ParagraphParser();
        paragraphParser.setSuccessor(sentenceParser);

        Component paragraphComposite = paragraphParser.parse(PARAGRAPH_WITH_TWO_SENTENCES);
        List<Component> sentenceComposites = paragraphComposite.getChildren();

        Assert.assertEquals(Composite.class, paragraphComposite.getClass());
        Assert.assertEquals(TWO_ELEMENTS, sentenceComposites.size());
    }
}
