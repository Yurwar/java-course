public class ConsoleView {
    public static final String MENU = String.format(
            "%s%n%s%n%s%n%s%n%s%n%s%n%s",
            "Choose what do you want to do:",
            "Press 1 to get all buses in bus park.",
            "Press 2 to get list of buses by route number.",
            "Press 3 to get list of buses that are in exploitation more than selected time interval.",
            "Press 4 to get list of buses that have mileage more than selected.",
            "Press 5 to exit.",
            "-> "
    );
    public static final String TABLE_HEADER = String.format(
            "%n%-20s%-12s%-14s%-11s%-25s%8s%n",
            "Driver",
            "Bus number",
            "Route number",
            "Bus brand",
            "Exploitation year start",
            "Mileage"
    );
    public static final String INCORRECT_INPUT_MSG = String.format(
            "%n%s%n%n",
            "Incorrect input"
    );

    public static final String FINAL_MSG = String.format("%n%s", "Goodbye :)");

    public void printMenu() {
        System.out.print(MENU);
    }
    public void printResultBusTable(Bus[] busArray) {
        if(busArray == null || busArray.length == 0) {
            System.out.println("\nNo matching results found\n");
            return;
        }
        System.out.print(TABLE_HEADER);
        for(Bus bus : busArray) {
            System.out.print(bus);
        }
        System.out.println();
    }

    public void printMsg(String msg) {
        System.out.print(msg);
    }
}
