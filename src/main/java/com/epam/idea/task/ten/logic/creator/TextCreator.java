package com.epam.idea.task.ten.logic.creator;

import com.epam.idea.task.ten.composite.Component;
import com.epam.idea.task.ten.composite.Lexeme;
import com.epam.idea.task.ten.exception.ComponentException;
import com.epam.idea.task.ten.logic.expression.ExpressionCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextCreator {
    private static final Logger logger = LogManager.getLogger(TextCreator.class);
    private static final String SPACES_BEFORE_TABS = "\\s+\\t";
    private static final String SPACES_AT_END = "\\s+$";

    private ExpressionCalculator calculator;

    public TextCreator(ExpressionCalculator calculator) {
        this.calculator = calculator;
    }

    public String createText(Component text) throws ComponentException{
        logger.info("Text creating is started");
        StringBuilder textBuilder = new StringBuilder();
        List<Lexeme> lexemes = getLexemes(text);
        for (Lexeme lexeme : lexemes) {
            String lexemeContent = lexeme.getValue();
            textBuilder.append(lexemeContent + " ");
        }
        logger.info("Text creating completed successfully");
        return textBuilder.toString().replaceAll(SPACES_BEFORE_TABS, "\t")
                .replaceAll(SPACES_AT_END, "");
    }

    private List<Lexeme> getLexemes(Component text) throws ComponentException{
        List<Component> paragraphs = text.getChildren();
        List<Component> sentences = new ArrayList<>();
        for (Component p : paragraphs) {
            for (Component component : p.getChildren()) {
                sentences.add(component);
            }
        }
        List<Component> lexemeComponents = new ArrayList<>();
        for (Component s : sentences) {
            for (Component component : s.getChildren()) {
                lexemeComponents.add(component);
            }
        }
        List<Lexeme> lexemes = new ArrayList<>();
        for (Component lexemeComponent : lexemeComponents) {
            Component resultLexeme = getLexemeValue(lexemeComponent);
            lexemes.add((Lexeme) resultLexeme);
        }
        return lexemes;
    }

    private Component getLexemeValue(Component lexemeComponent) {
        Lexeme lexeme = (Lexeme) lexemeComponent;
        String lexemeValue = lexeme.getValue();
        if (lexeme.isExpression()) {
            Integer expressionResult = calculator.calculateExpression(lexemeValue);
            return Lexeme.expression(expressionResult.toString());
        } else {
            return Lexeme.word(lexemeValue);
        }
    }
}
