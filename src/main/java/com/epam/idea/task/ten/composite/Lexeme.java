package com.epam.idea.task.ten.composite;

import com.epam.idea.task.ten.exception.ComponentException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lexeme implements Component{
    private final String value;
    private final boolean expression;

    private Lexeme(String value,boolean expression){
        this.value = value;
        this.expression = expression;
    }

    public static Lexeme word(String value){
        return new Lexeme(value,false);
    }

    public static Lexeme expression(String value){
        return new Lexeme(value,true);
    }

    public String getValue(){
        return value;
    }

    public boolean isExpression() {
        return expression;
    }

    @Override
    public void addComponent(Component component) throws ComponentException {
        throw new ComponentException("Lexeme doesn't have components.");
    }

    @Override
    public List<Component> getChildren() throws ComponentException {
        throw new ComponentException("Lexeme doesn't have components.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Lexeme lexeme = (Lexeme) o;
        return Objects.equals(value, lexeme.value);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Lexeme{" +
                "value='" + value + '\'' +
                '}';
    }
}
