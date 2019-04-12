package com.yurwar.pointset.views;

import com.yurwar.pointset.models.Point;

import java.util.HashSet;
import java.util.Iterator;

public class PointsView {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public void printMsg(String msg) {
        System.out.print(msg);
    }
    public void printPoints(HashSet<HashSet<Point>> pointsSets) {
        for (HashSet<Point> phs : pointsSets) {
            for (Point point : phs) {
                System.out.print(point + " ");
            }
            System.out.println();
        }
    }
    public void printPointsMatches(HashSet<HashSet<Point>> pointsSets, Point matchingPoint) {
        Iterator<HashSet<Point>> iterator = pointsSets.iterator();
        HashSet<Point> firstRow = iterator.next();
        for (Point p : firstRow) {
            if(!p.equals(matchingPoint)) {
                System.out.print(ANSI_RED + p + ANSI_RESET + "");
            } else {
                System.out.print(ANSI_BLUE + p + ANSI_RESET +  " ");
            }
        }
        System.out.println();

        while (iterator.hasNext()) {
            HashSet<Point> phs = iterator.next();
            for (Point point : phs) {
                if(!point.equals(matchingPoint)) {
                    System.out.print(point + " ");
                } else {
                    System.out.print(ANSI_BLUE + point + ANSI_RESET +  " ");
                }
            }
            System.out.println();
        }
    }
}
