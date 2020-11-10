package com.epam.idea.task.ten.logic.sorter;

import com.epam.idea.task.ten.composite.Component;
import com.epam.idea.task.ten.composite.Lexeme;
import com.epam.idea.task.ten.logic.sorter.comparator.LexemeComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class WordSorterByLength implements Sorter<Component> {
    private static final Logger logger = LogManager.getLogger(WordSorterByLength.class);

    @Override
    public List<Component> sort(List<Component> components) {
        List<Component> sortable = new ArrayList<>();
        for (Component component : components) {
            Lexeme lexeme = (Lexeme) component;
            if (!lexeme.isExpression()) {
                sortable.add(component);
            }
        }
        sortable.sort(new LexemeComparator());
        logger.info("Sentence has been successfully sorted by word length");
        return sortable;
    }
}
