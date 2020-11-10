package com.epam.idea.task.ten.reader;

import com.epam.idea.task.ten.exception.DataException;
import org.junit.Assert;
import org.junit.Test;

public class ReaderTest {
    private static final String EXPECTED_TEXT="It has survived - not only (five) centuries, but also the leap into 55+ electronic\n" +
            "typesetting, remaining 35+ essentially 21-5* unchanged. It was popularised in the\n" +
            "63+5*4 with the release of Letraset sheets containing Lorem\n" +
            "Ipsum passages, and more recently with desktop publishing software like Aldus\n" +
            "PageMaker including versions of Lorem Ipsum.\n" +
            "It is a long established fact that a reader will be distracted by the readable\n" +
            "content of a page when looking at its layout. The point of using\n" +
            "63- Ipsum is that it has a more-or-less normal\n" +
            "distribution of letters, as opposed to using (Content here), content here, making it look\n" +
            "like readable English.\n" +
            "It is a 33+8* established fact that a reader will be of a\n" +
            "page when looking at its layout.\n" +
            "Bye.";

    @Test
    public void shouldReadTextWhenPathValid() throws DataException {
        Reader textReader = new Reader();

        String actual = textReader.readInput();

        Assert.assertEquals(EXPECTED_TEXT,actual);
    }

}
