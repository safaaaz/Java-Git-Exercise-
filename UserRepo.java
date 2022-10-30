import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class UserRepo {

    private final Gson gson;
    private File file = null;


    public UserRepo() {
        this.gson = new Gson();
        createUsersFile();
    }

    void createUsersFile(){
        try {
            this.file = new File("./users.json");
        } catch (NullPointerException e) {
            throw new RuntimeException("Something went wrong, database file not found", e);
        }
    }

    void writeToFile(Map<Integer,User> usersData) throws FileNotFoundException {
        try(FileOutputStream fileOut = new FileOutputStream(this.file.getName())) {
            fileOut.write(gson.toJson(usersData).getBytes());
            fileOut.flush();
        }
        catch (IOException e) {
            throw new FileNotFoundException("Can't write to file");
        }
    }



    Map<Integer, User> getUsersData() throws FileNotFoundException {
        try{
            String result = new String(Files.readAllBytes(Paths.get("./users.json")));
            return this.gson.fromJson(result, new TypeToken<HashMap<Integer, User>>() {}.getType());
        }
        catch (IOException e) {
            throw new FileNotFoundException("Can't read from file");
        }
    }
}
