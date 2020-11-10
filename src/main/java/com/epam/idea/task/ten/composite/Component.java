package com.epam.idea.task.ten.composite;

import com.epam.idea.task.ten.exception.ComponentException;

import java.util.List;

public interface Component {
    void addComponent (Component component) throws ComponentException;
    List<Component> getChildren() throws ComponentException;
}
