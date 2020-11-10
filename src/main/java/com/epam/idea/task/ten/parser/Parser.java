package com.epam.idea.task.ten.parser;

import com.epam.idea.task.ten.composite.Component;
import com.epam.idea.task.ten.exception.ComponentException;

public interface Parser {
    Component parse(String text) throws ComponentException;
}
