package validnumber;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FindValidNumberTests {
    public static void main(String[] args) throws IOException {
        FindValidNumber findValidNumber = new FindValidNumber();
        Path path = Paths.get("src\\file.txt");
        findValidNumber.readFile(path);
    }
}
