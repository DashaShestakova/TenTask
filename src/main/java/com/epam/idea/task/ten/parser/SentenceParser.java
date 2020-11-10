package com.epam.idea.task.ten.parser;

import com.epam.idea.task.ten.composite.Component;
import com.epam.idea.task.ten.composite.Composite;
import com.epam.idea.task.ten.composite.Lexeme;
import com.epam.idea.task.ten.exception.ComponentException;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser{
    private static final String EXPRESSION_REGEX ="(\\d+\\s)((\\d+|[-+*/]))+[-+*/]";
    private static final Pattern PATTERN = Pattern.compile(EXPRESSION_REGEX);
    private static final String SEPARATOR = "\\s+";
    private static final String EXPRESSION_REPLACEMENT = "expression";

    @Override
    public Component parse(String sentence) throws ComponentException {
        Queue<String> expressions = searchExpressions(sentence);
        String sentenceWithReplacement = sentence.replaceAll(EXPRESSION_REGEX, EXPRESSION_REPLACEMENT);
        String[] words = sentenceWithReplacement.split(SEPARATOR);
        Component sentenceComponent = new Composite();
        for (String word : words) {
            Lexeme lexeme;
            if (word.compareTo(EXPRESSION_REPLACEMENT) == 0) {
                String expression = expressions.poll();
                lexeme = Lexeme.expression(expression);
            } else {
                lexeme = Lexeme.word(word);
            }
            sentenceComponent.addComponent(lexeme);
        }
        return sentenceComponent;
    }

    private Queue<String> searchExpressions(String sentence){
        Queue<String> expressions = new LinkedList<>();
        Matcher matcher = PATTERN.matcher(sentence);
        while(matcher.find()){
            String expression = matcher.group();
            expressions.add(expression);
        }
        return expressions;
    }

}
