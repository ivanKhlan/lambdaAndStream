package jsonfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class ReadJsonFile {
    BufferedReader br;
    int countLine = 0;
    ArrayList<User> allUsers = new ArrayList<>();
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
            if (++countLine == 1) {
                continue;
            } else {
                addUserToList(line);
            }
            countLine++;
        }
        createNewFile();
    }

    public void addUserToList(String line) {
        String[] anotherLine = line.split(" ");
        String name = anotherLine[0];
        int age = Integer.parseInt(anotherLine[1]);
        User user = new User(name, age);
        allUsers.add(user);
    }

    public void createNewFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(allUsers);
        System.out.println(json);
    }
}