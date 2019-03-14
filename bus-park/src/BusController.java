import java.util.Scanner;

public class BusController {
    private BusPark busPark;
    private ConsoleView view;
    private Scanner sc;

    public BusController() {
        busPark = new BusPark(new DataSource().getBusArray());
        view = new ConsoleView();
        sc = new Scanner(System.in);
    }

    public void start() {
        int inputNumber;

        outer: while (true){
            view.printMenu();

            inputNumber = sc.nextInt();

            switch (inputNumber) {
                case 1: {
                    view.printResultBusTable(busPark.getBuses());
                    break;
                }
                case 2: {
                    int routeToFind;
                    view.printMsg("Enter the route what would you like to find:\n-> ");
                    routeToFind = sc.nextInt();
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
            }
        }
        sc.close();
        view.printMsg("Goodbye :)");
    }


}
