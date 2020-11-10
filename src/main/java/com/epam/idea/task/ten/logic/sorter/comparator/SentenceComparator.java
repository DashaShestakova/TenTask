package com.epam.idea.task.ten.logic.sorter.comparator;

import com.epam.idea.task.ten.composite.Component;
import com.epam.idea.task.ten.exception.ComponentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class SentenceComparator implements Comparator<Component> {
    private final static Logger logger = LogManager.getLogger(SentenceComparator.class);
    @Override
    public int compare(Component firstComponent, Component secondComponent) {
        List<Component> firstChild = null;
        List<Component> secondChild = null;
        try {
            firstChild = firstComponent.getChildren();
            secondChild = secondComponent.getChildren();
        }catch (ComponentException e){
            logger.error("ComponentException" + e.getMessage());
        }
        return firstChild.size() - secondChild.size();
    }
}
