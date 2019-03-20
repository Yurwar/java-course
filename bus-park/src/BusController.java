import java.util.Scanner;

public class BusController {
    private BusPark busPark;
    private ConsoleView view;
    private ConsoleReader reader;

    public BusController() {
        busPark = new BusPark(new DataSource().getBusArray());
        view = new ConsoleView();
        reader = new ConsoleReader();
    }

    public void start() {
        int inputNumber;

        outer: while (true){
            view.printMenu();

            inputNumber = reader.readInt();

            switch (inputNumber) {
                case 1: {
                    view.printResultBusTable(busPark.getBuses());
                    break;
                }
                case 2: {
                    int routeToFind;
                    view.printMsg("Enter the route what would you like to find:\n-> ");
                    try {
                        routeToFind = reader.readInt();
                    } catch (NumberFormatException e) {
                        view.printMsg("Incorrect input\n");
                        break;
                    }
                    view.printResultBusTable(busPark.getByRouteNumber(routeToFind));
                    break;
                }
                case 3: {
                    view.printResultBusTable(busPark.getByExploitation());
                    break;
                }
                case 4: {
                    view.printResultBusTable(busPark.getByMileage());
                    break;
                }
                case 5: break outer;
                default: {
                    view.printMsg("Incorrect input\n");
                    break;
                }
            }
        }
        view.printMsg("Goodbye :)");
    }


}
