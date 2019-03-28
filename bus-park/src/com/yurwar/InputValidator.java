package com.yurwar;

import com.yurwar.exceptions.NumberOutOfRangeException;

public class InputValidator {
    public static void checkExploitationTimeInterval(int exploitationTimeInteval) throws NumberOutOfRangeException {
        if(exploitationTimeInteval < 0 || exploitationTimeInteval > 100) {
            throw new NumberOutOfRangeException(
                    "Time interval is out of range from 0 to 100", exploitationTimeInteval
            );
        }
    }
    public static void checkRouteNumberRange(int routeNumber) throws NumberOutOfRangeException {
        if(routeNumber <= 0 || routeNumber >= 1000) {
            throw new NumberOutOfRangeException(
                    "Input route number out of range from 1 to 1000", routeNumber
            );
        }
    }
    public static void checkMileageRange(int mileage) throws NumberOutOfRangeException {
        if(mileage < 0 || mileage > 10_000_000) {
            throw new NumberOutOfRangeException(
                    "Input mileage out of range from 1 to 10,000,000", mileage
            );
        }
    }
}
