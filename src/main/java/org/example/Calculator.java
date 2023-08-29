package org.example;

public class Calculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("denominator can`t be 0!");
        }
        return a / b;
    }
}
