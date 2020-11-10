package com.epam.idea.task.ten.parser;

import com.epam.idea.task.ten.composite.Component;
import com.epam.idea.task.ten.composite.Composite;
import com.epam.idea.task.ten.exception.ComponentException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser{
    private static final Pattern pattern = Pattern.compile("([^.!?]+[.!?])");

    @Override
    public Component parse(String text) throws ComponentException {
        Matcher sentenceMatcher = pattern.matcher(text);
        Component paragraphComponent = new Composite();
        while (sentenceMatcher.find()) {
            Component sentenceComponent = successor.parse(sentenceMatcher.group());
            paragraphComponent.addComponent(sentenceComponent);
        }
        return paragraphComponent;
    }
}
