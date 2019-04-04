package com.yurwar.exceptions;

public class NumberOutOfRangeException extends Exception {
    private int number;
    public NumberOutOfRangeException(String msg) {
        super(msg);
    }
    public NumberOutOfRangeException(String msg, int number) {
        super(msg);
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
}
