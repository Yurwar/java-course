package com.yurwar;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleReader implements Reader {
    private Scanner sc;
    private InputStream inputStream;

    public ConsoleReader() {
        inputStream = System.in;
        sc = new Scanner(inputStream);
    }

    public int readInt() throws NumberFormatException {
        return Integer.parseInt(sc.next());
    }

    public String readString() {
        return sc.next();
    }
}
