package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class UserRepo {

    private static Gson gson = null;
    private static File file;

    private static Map<String, User> usersData = new HashMap<>();


    public UserRepo() {
        gson = new Gson();
        createUsersFile();
        readUsersData();

    }

    void createUsersFile(){
        try {
            file = new File("./users.json");
        } catch (NullPointerException e) {
            throw new RuntimeException("Something went wrong, database file not found", e);
        }
    }

    static void writeToFile(Map<String, User> usersData) {
        try(FileOutputStream fileOut = new FileOutputStream(file.getName())) {
            fileOut.write(gson.toJson(usersData).getBytes());
            fileOut.flush();
        }
        catch (IOException e) {
            throw new RuntimeException("Can't write to file");
        }
    }

    static void saveNewUser(User user){
        usersData.put(user.getEmail(), user);
        writeToFile(usersData);
    }

    static void updateUser(User user){
        usersData.put(user.getEmail(), user);
        writeToFile(usersData);
    }

    static void deleteUser(User user){
        usersData.remove(user.getEmail(), user);
        writeToFile(usersData);
    }

    public static Map<String, User> getUsersData(){
        return usersData;
    }


    void readUsersData() {
        try{
            String result = new String(Files.readAllBytes(Paths.get(file.getName())));
            usersData = gson.fromJson(result, new TypeToken<HashMap<Integer, User>>() {}.getType());
        }
        catch (IOException e) {
            throw new RuntimeException("Can't read from file");
        }
    }
}
