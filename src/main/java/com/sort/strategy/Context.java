package com.sort.strategy;

public class Context {

    private final Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    public void arrange(String[] input, char sortOrder) {
        if (sortOrder == 'A' || sortOrder == 'D') {
            strategy.sort(input, sortOrder);
           //App.printNames(input);
        }  else {
            System.out.println("Please enter A for ascending order or D for descending order!");
        }
    }

}
