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
            try {
                inputNumber = reader.readInt();
            } catch (NumberFormatException e) {
                view.printMsg("\nIncorrect input\n\n");
                continue;
            }

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
                        view.printMsg("\nIncorrect input\n\n");
                        break;
                    }
                    view.printResultBusTable(busPark.getByRouteNumber(routeToFind));
                    break;
                }
                case 3: {
                    int lowerExploitationInteval;
                    view.printMsg("Enter the lower exploitation time interval:\n-> ");
                    try {
                        lowerExploitationInteval = reader.readInt();
                    } catch (NumberFormatException e) {
                        view.printMsg("\nIncorrect input\n\n");
                        break;
                    }
                    view.printResultBusTable(busPark.getByExploitation(lowerExploitationInteval));
                    break;
                }
                case 4: {
                    int lowerMileage;
                    view.printMsg("Enter the lower mileage to find:\n-> ");
                    try {
                        lowerMileage = reader.readInt();
                    } catch (NumberFormatException e) {
                        view.printMsg("\nIncorrect input\n\n");
                        break;
                    }
                    view.printResultBusTable(busPark.getByMileage(lowerMileage));
                    break;
                }
                case 5: break outer;
                default: {
                    view.printMsg("\nIncorrect input\n\n");
                    break;
                }
            }
        }
        view.printMsg("Goodbye :)");
    }


}
