package amountrepeatword;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class AmountRepeatWord {
    BufferedReader br;
    ArrayList<String> allWords = new ArrayList<>();
    HashMap<String, Integer> unique = new HashMap<>();


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
            splitAllWords(line);
        }
        getCountUniqueWords();
    }

    public void splitAllWords(String line) {
        String[] words = line.split(" ");
        allWords.addAll(Arrays.asList(words));
    }

    public void getCountUniqueWords() {
        for (int i = 0; i < allWords.size(); i++) {
            if (!allWords.get(i).isEmpty()) {
                countWords(allWords.get(i));
                i--;
            }

        }
        unique.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }

    public void countWords(String word) {
        int digit = 0;
        for (int i = 0; i < allWords.size(); i++) {
            if (allWords.get(i).equals(word)) {
                digit++;
                allWords.remove(i);
                i--;
            }
        }
        unique.put(word,digit);
    }
}