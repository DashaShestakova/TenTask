package com.epam.idea.task.ten.logic.expression;

import com.epam.idea.task.ten.logic.expression.operations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpressionCalculator implements Calculator {

    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char MULTIPLY = '*';
    public static final char DIVIDE = '/';

    @Override
    public int calculateExpression(String inputExpression) {
        Expression expression = new Expression();
        List<ArithmeticOperation> abstractExpressions = parseExpression(inputExpression);
        for (ArithmeticOperation operation : abstractExpressions) {
            operation.interpret(expression);
        }
        return expression.popValue();
    }

    private List<ArithmeticOperation> parseExpression(String inputExpression) {
        List<ArithmeticOperation> arithmeticOperations = new ArrayList<>();
        for (String lexeme : inputExpression.split("\\s")) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char symbol = lexeme.charAt(0);
            switch (symbol) {
                case PLUS:
                    arithmeticOperations.add(new OperationPlus());
                    break;
                case MINUS:
                    arithmeticOperations.add(new OperationMinus());
                    break;
                case MULTIPLY:
                    arithmeticOperations.add(new OperationMultiply());
                    break;
                case DIVIDE:
                    arithmeticOperations.add(new OperationDivide());
                    break;
                default:
                    Scanner scan = new Scanner(lexeme);
                    if (scan.hasNextInt()) {
                        arithmeticOperations.add(
                                new ExpressionNumber(scan.nextInt()));
                    }
            }
        }
        return arithmeticOperations;
    }
}
