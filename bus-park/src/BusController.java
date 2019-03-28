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
                view.printMsg(ConsoleView.INCORRECT_INPUT_MSG);
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
                        InputValidator.checkRouteNumberRange(routeToFind);
                    } catch (NumberFormatException e) {
                        view.printMsg(ConsoleView.INCORRECT_INPUT_MSG);
                        break;
                    } catch (NumberOutOfRangeException e) {
                        view.printMsg('\n' + e.getMessage() + "\nYour route: " + e.getNumber() + "\n\n");
                        break;
                    }

                    view.printResultBusTable(busPark.getByRouteNumber(routeToFind));
                    break;
                }
                case 3: {
                    int lowerExploitationInterval;
                    view.printMsg("Enter the lower exploitation time interval in years:\n-> ");

                    try {
                        lowerExploitationInterval = reader.readInt();
                        InputValidator.checkExploitationTimeInterval(lowerExploitationInterval);
                    } catch (NumberFormatException e) {
                        view.printMsg(ConsoleView.INCORRECT_INPUT_MSG);
                        break;
                    } catch (NumberOutOfRangeException e) {
                        view.printMsg('\n' + e.getMessage() + "\nYour time interval: " + e.getNumber() + "\n\n");
                        break;
                    }

                    view.printResultBusTable(busPark.getByExploitation(lowerExploitationInterval));
                    break;
                }
                case 4: {
                    int lowerMileage;
                    view.printMsg("Enter the lower mileage to find:\n-> ");

                    try {
                        lowerMileage = reader.readInt();
                        InputValidator.checkMileageRange(lowerMileage);
                    } catch (NumberFormatException e) {
                        view.printMsg(ConsoleView.INCORRECT_INPUT_MSG);
                        break;
                    } catch (NumberOutOfRangeException e) {
                        view.printMsg('\n' + e.getMessage() + "\nYour mileage: " + e.getNumber() + "\n\n");
                        break;
                    }

                    view.printResultBusTable(busPark.getByMileage(lowerMileage));
                    break;
                }
                case 5: break outer;
                default: {
                    view.printMsg(ConsoleView.INCORRECT_INPUT_MSG);
                    break;
                }
            }
        }
        view.printMsg(ConsoleView.FINAL_MSG);
    }


}
