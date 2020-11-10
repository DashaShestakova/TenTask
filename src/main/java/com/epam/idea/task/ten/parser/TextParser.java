package com.epam.idea.task.ten.parser;

import com.epam.idea.task.ten.composite.Component;
import com.epam.idea.task.ten.composite.Composite;
import com.epam.idea.task.ten.exception.ComponentException;

import java.util.Arrays;
import java.util.List;

public class TextParser extends AbstractParser {
    private static final String SEPARATOR = "\n";

    @Override
    public Component parse(String text) throws ComponentException {
        List<String> paragraphs = Arrays.asList(text.split(SEPARATOR));
        Component textComponent = new Composite();

        for (String paragraph : paragraphs) {
            Component paragraphComponent = successor.parse(paragraph);
            textComponent.addComponent(paragraphComponent);
        }
        return textComponent;
    }
}
