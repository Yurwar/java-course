package com.yurwar.model;

import com.yurwar.InputValidator;
import com.yurwar.exceptions.BusNumberFormatException;
import com.yurwar.exceptions.NumberOutOfRangeException;

import java.util.Objects;

public class Bus {
    private Driver driver;
    private String busNumber;
    private int routeNumber;
    private String busBrand;
    private int exploitationYearStart;
    private int mileage;

    public Bus(Driver driver, String busNumber,
               int routeNumber, String busBrand,
               int exploitationYearStart, int mileage) {
        this.driver = driver;
        this.busNumber = busNumber;
        this.routeNumber = routeNumber;
        this.busBrand = busBrand;
        this.exploitationYearStart = exploitationYearStart;
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return String.format(
                "%-20s%-12s%-14d%-11s%-25d%,8d%n",
                driver,
                busNumber,
                routeNumber,
                busBrand,
                exploitationYearStart,
                mileage
        );
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        if(driver == null) {
            throw new NullPointerException();
        }
        this.driver = driver;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) throws BusNumberFormatException {
        InputValidator.checkBusNumberFormat(busNumber);
        this.busNumber = busNumber;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) throws NumberOutOfRangeException {
        InputValidator.checkRouteNumberRange(routeNumber);
        this.routeNumber = routeNumber;
    }

    public String getBusBrand() {
        return busBrand;
    }

    public void setBusBrand(String busBrand) {
        this.busBrand = busBrand;
    }

    public int getExploitationYearStart() {
        return exploitationYearStart;
    }

    public void setExploitationYearStart(int exploitationYearStart) {
        this.exploitationYearStart = exploitationYearStart;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) throws NumberOutOfRangeException {
        InputValidator.checkMileageRange(mileage);
        this.mileage = mileage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bus)) return false;
        Bus bus = (Bus) o;
        return routeNumber == bus.routeNumber &&
                exploitationYearStart == bus.exploitationYearStart &&
                mileage == bus.mileage &&
                driver.equals(bus.driver) &&
                busNumber.equals(bus.busNumber) &&
                busBrand.equals(bus.busBrand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driver, busNumber, routeNumber, busBrand, exploitationYearStart, mileage);
    }
}
