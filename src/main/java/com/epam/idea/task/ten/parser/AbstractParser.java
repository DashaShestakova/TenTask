package com.epam.idea.task.ten.parser;

public abstract class AbstractParser implements Parser{
    protected Parser successor;

    public AbstractParser(){
    }

    public AbstractParser(Parser successor){
        this.successor = successor;
    }

    public Parser getSuccessor() {
        return successor;
    }

    public void setSuccessor(Parser successor) {
        this.successor = successor;
    }
}
