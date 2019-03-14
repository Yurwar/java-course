import java.text.SimpleDateFormat;
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
        Bus[] resultBusArray;
        for(Bus bus : buses) {
            if(bus.getRouteNumber() == routeNumber) {
                acceptableBusCount++;
            }
        }
        if(acceptableBusCount == 0) {
            return null;
        } else {
            resultBusArray = new Bus[acceptableBusCount];
            int i = 0;
            for(Bus bus : buses) {
                if(bus.getRouteNumber() == routeNumber) {
                    resultBusArray[i++] = bus;
                }
            }
            return resultBusArray;
        }
    }

    public Bus[] getByExploitation() {
        int acceptableBusCount = 0;
        Bus[] resultBusArray;

        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        int currentYear = calendar.get(Calendar.YEAR);

        for(Bus bus : buses) {
            if(currentYear - bus.getExploitationYearStart() > 10) {
                acceptableBusCount++;
            }
        }

        if(acceptableBusCount == 0) {
            return null;
        } else {
            resultBusArray = new Bus[acceptableBusCount];
            int i = 0;
            for(Bus bus : buses) {
                if(currentYear - bus.getExploitationYearStart() > 10) {
                    resultBusArray[i++] = bus;
                }
            }
            return resultBusArray;
        }
    }

    public Bus[] getByMileage() {
        int acceptableBusCount = 0;
        Bus[] resultBusArray;
        for(Bus bus : buses) {
            if(bus.getMileage() > 100_000) {
                acceptableBusCount++;
            }
        }
        if(acceptableBusCount == 0) {
            return null;
        } else {
            resultBusArray = new Bus[acceptableBusCount];
            int i = 0;
            for(Bus bus : buses) {
                if(bus.getMileage() > 100_000) {
                    resultBusArray[i++] = bus;
                }
            }
            return resultBusArray;
        }
    }


}
