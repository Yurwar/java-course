package com.yurwar.exceptions;

public class BusNumberFormatException extends Exception {
    private String number;
    public BusNumberFormatException(String msg) {
        super(msg);
    }
    public BusNumberFormatException(String msg, String number) {
        super(msg);
        this.number = number;
    }
}
