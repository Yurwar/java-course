import java.io.InputStream;
import java.util.Scanner;

public class ConsoleReader {
    private Scanner sc;
    private InputStream inputStream;

    public ConsoleReader() {
        inputStream = System.in;
        sc = new Scanner(inputStream);
    }
    public int readInt() throws NumberFormatException {
        return Integer.parseInt(sc.next());
    }
}
