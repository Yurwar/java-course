package com.yurwar.pointset;

import java.util.Scanner;

public class ConsoleReader {
    private Scanner sc;

    public ConsoleReader() {
        sc = new Scanner(System.in);
    }
    public int readInt() throws NumberFormatException {
        return sc.nextInt();
    }
    public String readLine() {
        return sc.next();
    }
}
