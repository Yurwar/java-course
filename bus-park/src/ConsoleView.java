public class ConsoleView {
    public void printMenu() {
        System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s", "Choose what do you want to do:",
                "Press 1 to get all buses in bus park.",
                "Press 2 to get list of buses by route number.",
                "Press 3 to get list of buses that are in exploitation more than 10 years.",
                "Press 4 to get list of buses that have more than 100,000km of mileage.",
                "Press 5 to exit.",
                "-> "
                );
    }
    public void printResultBusTable(Bus[] busArray) {
        if(busArray == null) {
            System.out.println("No matching results found");
            return;
        }
        System.out.printf(
                "%-20s%-12s%-14s%-11s%-25s%8s%n",
                "Driver",
                "Bus number",
                "Route number",
                "Bus brand",
                "Exploitation year start",
                "Mileage"
        );
        for(Bus bus : busArray) {
            System.out.printf(
                    "%-20s%-12s%-14d%-11s%-25d%,8d%n",
                    bus.getDriver().getFirstName() + " " + bus.getDriver().getLastName(),
                    bus.getBusNumber(),
                    bus.getRouteNumber(),
                    bus.getBusBrand(),
                    bus.getExploitationYearStart(),
                    bus.getMileage()
            );
        }
        System.out.println();
    }

    public void printMsg(String msg) {
        System.out.print(msg);
    }
}
