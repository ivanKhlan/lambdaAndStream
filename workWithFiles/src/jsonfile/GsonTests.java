package jsonfile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GsonTests {
    public static void main(String[] args) throws IOException {
        ReadJsonFile readJsonFile = new ReadJsonFile();
        Path path = Paths.get("src\\user.txt");
        readJsonFile.readFile(path);
    }
}
