package com.epam.idea.task.ten.logic.sorter;

import com.epam.idea.task.ten.composite.Component;

import java.util.List;

public interface Sorter<Component> {
    List<Component> sort(List<Component> sorted);
}
