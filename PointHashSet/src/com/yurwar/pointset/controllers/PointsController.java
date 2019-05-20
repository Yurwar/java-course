package com.yurwar.pointset.controllers;

import com.yurwar.pointset.ConsoleReader;
import com.yurwar.pointset.models.Point;
import com.yurwar.pointset.models.PointsHashSets;
import com.yurwar.pointset.views.PointsView;

public class PointsController {
    private PointsHashSets pointsSetsModel;
    private PointsView pointsView;
    private ConsoleReader reader;

    public PointsController() {
        pointsView = new PointsView();
        reader = new ConsoleReader();
    }

    public void execute() {
        String condition;
        do {
            int amountOfSets = -1, amountOfPoints = -1;
            try {
                pointsView.printMsg("Enter amount of sets: \n-> ");
                amountOfSets = reader.readInt();
                pointsView.printMsg("Enter amount of points: \n-> ");
                amountOfPoints = reader.readInt();
            } catch (NumberFormatException e) {
                pointsView.printMsg("\nIncorrect input\n");
                e.printStackTrace();
            }
            try {
                if (amountOfSets > 0 && amountOfPoints > 0) {
                    pointsView.printMsg("Creating " + amountOfSets + " sets with " + amountOfPoints + " points in it\n");
                    pointsSetsModel = new PointsHashSets(amountOfSets, amountOfPoints);
                } else {
                    throw new IllegalArgumentException("\nIncorrect input\n");
                }
            } catch (IllegalArgumentException e) {
                pointsView.printMsg(e.getMessage());
                return;
            }
            pointsView.printMsg("Generating random sets of points\n");
            pointsSetsModel.generateRandomSets();
            pointsView.printPoints(pointsSetsModel.getPointsSets());
            Point mostEncounteredPoint = pointsSetsModel.getMostEncounteredPoint();
            if (mostEncounteredPoint != null) {
                pointsView.printMsg("Most encountered point from sets is: " + mostEncounteredPoint + "\n");
                pointsView.printPointsMatches(pointsSetsModel.getPointsSets(), mostEncounteredPoint);
            } else {
                pointsView.printMsg("Have not found any encountered points\n");
            }
            pointsView.printMsg("Do you want to continue?(y/N):\n-> ");
            condition = reader.readLine();
            pointsView.printMsg("\n\n");
        } while (condition.equalsIgnoreCase("y"));
        pointsView.printMsg("\nGoodbye :)\n");
    }
}
