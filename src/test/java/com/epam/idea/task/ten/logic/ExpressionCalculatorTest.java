package com.epam.idea.task.ten.logic;

import com.epam.idea.task.ten.logic.expression.ExpressionCalculator;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class ExpressionCalculatorTest {
    @DataProvider
    public static Object[][] expressionCalculator() {
        return new Object[][] {
                { "5 4 * 5 - 30 +",15 },
                { "2 4 - 2 + 12 *",48 },
                { "2 12 + 28 /",2}
        };
    }

    @Test
    @UseDataProvider("expressionCalculator")
    public void shouldCalculateExpressionsWhenDataValid(String expression,int expected){
        ExpressionCalculator prnCalculator = new ExpressionCalculator();

        int actual = prnCalculator.calculateExpression(expression);

        Assert.assertEquals(expected,actual);
    }
}
