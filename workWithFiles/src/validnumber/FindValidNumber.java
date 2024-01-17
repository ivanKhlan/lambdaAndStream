package validnumber;

import java.io.*;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindValidNumber {

    BufferedReader br;
    public void readFile(Path fileName) throws IOException {
        {
            try {
                br = new BufferedReader(new FileReader(fileName.toFile()));
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }

        String line;
        while ((line = br.readLine()) != null) {
            if (checkNumber(line)) {
                System.out.println(line);
            }
        }
    }
    public boolean checkNumber(String line) {
        Pattern pattern = Pattern.compile("^\\(\\d{3}\\) \\d{3}-\\d{4}$"
                + "|^\\d{3}-\\d{3}-\\d{4}$");
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }
}


