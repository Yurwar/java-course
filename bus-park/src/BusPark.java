import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class BusPark {
    private Bus[] buses;

    public BusPark(Bus[] buses) {
        this.buses = buses;
    }

    public Bus[] getBuses() {
        return buses;
    }

    public void setBuses(Bus[] buses) {
        this.buses = buses;
    }

    public Bus[] getByRouteNumber(int routeNumber) {
        int acceptableBusCount = 0;
        Bus[] resultBusArray = new Bus[buses.length];
        for (Bus bus : buses) {
            if (bus.getRouteNumber() == routeNumber) {
                resultBusArray[acceptableBusCount] = bus;
                acceptableBusCount++;
            }
        }
        if(acceptableBusCount == 0) {
            return null;
        } else {
            return Arrays.copyOf(resultBusArray, acceptableBusCount);
        }
    }

    public Bus[] getByExploitation(int lowerDate) {
        int acceptableBusCount = 0;
        Bus[] resultBusArray = new Bus[buses.length];

        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        int currentYear = calendar.get(Calendar.YEAR);

        for (Bus bus : buses) {
            if (currentYear - bus.getExploitationYearStart() > lowerDate) {
                resultBusArray[acceptableBusCount] = bus;
                acceptableBusCount++;
            }
        }

        if(acceptableBusCount == 0) {
            return null;
        } else {
            return Arrays.copyOf(resultBusArray, acceptableBusCount);
        }
    }

    public Bus[] getByMileage(int lowerMileage) {
        int acceptableBusCount = 0;
        Bus[] resultBusArray = new Bus[buses.length];

        for (Bus bus : buses) {
            if (bus.getMileage() > lowerMileage) {
                resultBusArray[acceptableBusCount] = bus;
                acceptableBusCount++;
            }
        }
        if(acceptableBusCount == 0) {
            return null;
        } else {
            return Arrays.copyOf(resultBusArray, acceptableBusCount);
        }
    }


}
