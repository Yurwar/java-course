package com.yurwar.pointset.models;

import java.util.*;

public class PointsHashSets {
    private int amountOfSets;
    private int amountOfPoints;
    private Random random;

    private HashSet<HashSet<Point>> pointsSets;

    {
        random = new Random();
    }
    public PointsHashSets (int amountOfSets, int amountOfPoints) {
        this.amountOfSets = amountOfSets;
        this.amountOfPoints = amountOfPoints;
        pointsSets = new HashSet<>();
    }

    public HashSet<HashSet<Point>> generateRandomSets() {
        for (int i = 0; i < amountOfSets; i++) {
            HashSet<Point> pointHashSet = new HashSet<>();
            for(int j = 0; j < amountOfPoints; j++) {
                pointHashSet.add(new Point(random.nextInt(6), random.nextInt(6)));
            }
            pointsSets.add(pointHashSet);
        }
        return pointsSets;
    }

    public Point getMostEncounteredPoint() {
        ArrayList<Integer> pointsMeetCounters = new ArrayList<>(amountOfPoints);
        int meetCounterPos = 0;

        Iterator<HashSet<Point>> firstRowIt = pointsSets.iterator();
        HashSet<Point> firstRow = firstRowIt.next();
        for(Point p : firstRow) {
            pointsMeetCounters.add(0);
            Iterator<HashSet<Point>> pointsSetsIterator = pointsSets.iterator();
            pointsSetsIterator.next();
            for (; pointsSetsIterator.hasNext();) {
                HashSet<Point> currentRow = pointsSetsIterator.next();
                if(currentRow.contains(p)) {
                    int currentCounter = pointsMeetCounters.get(meetCounterPos);
                    pointsMeetCounters.set(meetCounterPos, currentCounter + 1);
                }
            }
            ++meetCounterPos;
        }

        int counterOfMEP = Collections.max(pointsMeetCounters);
        if (counterOfMEP > 0) {
            int indexOfMEP = pointsMeetCounters.indexOf(counterOfMEP);
            Iterator<Point> pointIterator = firstRow.iterator();
            Point resPoint = null;
            for(int i = 0; i <= indexOfMEP; i++) {
                resPoint = pointIterator.next();
            }
            return resPoint;
        }
        return null;
    }

    public HashSet<HashSet<Point>> getPointsSets() {
        return pointsSets;
    }

}
