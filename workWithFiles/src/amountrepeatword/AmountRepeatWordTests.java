package amountrepeatword;

import jsonfile.ReadJsonFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AmountRepeatWordTests {
    public static void main(String[] args) throws IOException {
        AmountRepeatWord amountRepeatWord = new AmountRepeatWord();
        Path path = Paths.get("src\\words.txt");
        amountRepeatWord.readFile(path);
    }
}
