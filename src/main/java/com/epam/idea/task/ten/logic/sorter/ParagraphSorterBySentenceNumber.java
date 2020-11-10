package com.epam.idea.task.ten.logic.sorter;

import com.epam.idea.task.ten.composite.Component;
import com.epam.idea.task.ten.logic.creator.TextCreator;
import com.epam.idea.task.ten.logic.sorter.comparator.SentenceComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ParagraphSorterBySentenceNumber implements Sorter<Component> {
    private static final Logger logger = LogManager.getLogger(ParagraphSorterBySentenceNumber.class);

    @Override
    public List<Component> sort(List<Component> composites) {
        List<Component> sortable = new ArrayList<>(composites);
        sortable.sort(new SentenceComparator());
        logger.info("Paragraph has been successfully sorted by sentence number");
        return sortable;
    }
}
