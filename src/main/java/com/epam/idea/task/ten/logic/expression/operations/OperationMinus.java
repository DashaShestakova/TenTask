package com.epam.idea.task.ten.logic.expression.operations;

import com.epam.idea.task.ten.logic.expression.Expression;

public class OperationMinus extends ArithmeticOperation {
    @Override
    public void interpret(Expression expression) {
        int firstOperand = expression.popValue();
        int secondOperand = expression.popValue();
        expression.pushValue(firstOperand - secondOperand);
    }
}
