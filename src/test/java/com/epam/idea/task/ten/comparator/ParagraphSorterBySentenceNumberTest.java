package com.epam.idea.task.ten.comparator;

import com.epam.idea.task.ten.composite.Component;
import com.epam.idea.task.ten.composite.Composite;
import com.epam.idea.task.ten.logic.sorter.ParagraphSorterBySentenceNumber;
import com.epam.idea.task.ten.logic.sorter.Sorter;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ParagraphSorterBySentenceNumberTest {
    private static final int FIRST = 0;
    private static final int SECOND = 1;

    @Test
    public void testSortShouldReturnSortedParagraphsWhenFirstParagraphHasMoreSentences() {
        Component firstSentenceComponent = new Composite();
        Component secondSentenceComponent = new Composite();
        Composite firstParagraphComposite = new Composite();
        firstParagraphComposite.addComponent(firstSentenceComponent);
        firstParagraphComposite.addComponent(secondSentenceComponent);

        Component thirdSentenceComponent = new Composite();
        Composite secondParagraphComposite = new Composite();
        secondParagraphComposite.addComponent(thirdSentenceComponent);

        List<Component> unsorted = Arrays.asList(firstParagraphComposite, secondParagraphComposite);

        Sorter<Component> sorter = new ParagraphSorterBySentenceNumber();

        List<Component> sorted = sorter.sort(unsorted);

        Component firstSecondComposite = sorted.get(FIRST);
        Assert.assertEquals(secondParagraphComposite, firstSecondComposite);

        Component secondSortedComposite = sorted.get(SECOND);
        Assert.assertEquals(firstParagraphComposite, secondSortedComposite);
    }
}
