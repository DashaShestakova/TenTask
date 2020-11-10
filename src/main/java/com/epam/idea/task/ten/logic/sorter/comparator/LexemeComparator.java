package com.epam.idea.task.ten.logic.sorter.comparator;

import com.epam.idea.task.ten.composite.Component;
import com.epam.idea.task.ten.composite.Lexeme;

import java.util.Comparator;

public class LexemeComparator implements Comparator<Component> {
    @Override
    public int compare(Component firstComponent, Component secondComponent) {
        Lexeme firstLexeme = (Lexeme) firstComponent;
        Lexeme secondLexeme = (Lexeme) secondComponent;

        String firstLexemeValue = firstLexeme.getValue();
        String secondLexemeValue = secondLexeme.getValue();

        return firstLexemeValue.length() - secondLexemeValue.length();
    }
}
