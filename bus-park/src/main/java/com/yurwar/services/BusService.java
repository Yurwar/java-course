package com.yurwar.services;

import com.yurwar.FileOperator;
import com.yurwar.InputValidator;
import com.yurwar.Reader;
import com.yurwar.exceptions.NumberOutOfRangeException;
import com.yurwar.model.BusPark;
import com.yurwar.view.ConsoleView;
import com.yurwar.view.View;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BusService {
    private static final Logger logger = LogManager.getLogger(BusService.class);
    public static void fillBusArrayFromFile(BusPark busPark, FileOperator fileOperator, View view) {
        try {
            logger.trace("Reading from file");
            busPark.setBuses(fileOperator.read());
        } catch (FileNotFoundException e) {
            logger.fatal("File not found: " + e.getMessage());
            view.printMsg(ConsoleView.FILE_NOT_FOUND_MSG);
            System.exit(-1);
        } catch (IOException e) {
            logger.error("Can not fill the table");
            view.printMsg("\nCan not fill the table\n\n");
            System.exit(-1);
        }
    }
    public static int getRouteToFind(View view, Reader reader) {
        view.printMsg("Enter the route what would you like to find:\n-> ");
        try {
            int routeToFind = reader.readInt();
            InputValidator.checkRouteNumberRange(routeToFind);
            return routeToFind;
        } catch (NumberFormatException e) {
            logger.warn("Incorrect input. Can not parse integer");
            view.printMsg(ConsoleView.INCORRECT_INPUT_MSG);
            return getRouteToFind(view, reader);
        } catch (NumberOutOfRangeException e) {
            logger.warn("Entered route: " + e.getNumber() + " is out of range");
            view.printMsg('\n' + e.getMessage() + "\nYour route: " + e.getNumber() + "\n\n");
            return getRouteToFind(view, reader);
        }
    }
    public static int getLowerExploitationInterval(View view, Reader reader) {
        view.printMsg("Enter the lower exploitation time interval in years:\n-> ");
        try {
            int lowerExploitationInterval = reader.readInt();
            InputValidator.checkExploitationTimeInterval(lowerExploitationInterval);
            return lowerExploitationInterval;
        } catch (NumberFormatException e) {
            logger.warn("Incorrect input. Can not parse integer");
            view.printMsg(ConsoleView.INCORRECT_INPUT_MSG);
            return getLowerExploitationInterval(view, reader);
        } catch (NumberOutOfRangeException e) {
            logger.warn("Entered exploitation interval: " + e.getNumber() + " is out of range");
            view.printMsg('\n' + e.getMessage() + "\nYour time interval: " + e.getNumber() + "\n\n");
            return getLowerExploitationInterval(view, reader);
        }
    }
    public static int getLowerMileage(View view, Reader reader) {
        view.printMsg("Enter the lower mileage to find:\n-> ");
        try {
            int lowerMileage = reader.readInt();
            InputValidator.checkMileageRange(lowerMileage);
            return lowerMileage;
        } catch (NumberFormatException e) {
            logger.warn("Incorrect input. Can not parse integer");
            view.printMsg(ConsoleView.INCORRECT_INPUT_MSG);
            return getLowerMileage(view, reader);
        } catch (NumberOutOfRangeException e) {
            logger.warn("Entered lower mileage: " + e.getNumber() + " is out of range");
            view.printMsg('\n' + e.getMessage() + "\nYour mileage: " + e.getNumber() + "\n\n");
            return getLowerMileage(view, reader);
        }
    }
}
