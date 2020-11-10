package com.epam.idea.task.ten.logic.expression;

import com.epam.idea.task.ten.logic.expression.operations.ArithmeticOperation;

public class ExpressionNumber extends ArithmeticOperation {
    private int number;

    public ExpressionNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Expression expression) {
        expression.pushValue(number);
    }
}
