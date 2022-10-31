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
    private static Map<String, User> usersData;


    private UserRepo() {
    }

    public static void initUserRepo(){
        gson = new Gson();
        usersData = new HashMap<>();
        createUsersFile();
        readUsersData();
    }

    private static void createUsersFile(){
        try {
            file = new File("./users.json");
            if(!file.exists()){
                file.createNewFile();
            }
        } catch (NullPointerException e) {
            throw new RuntimeException("Something went wrong, database file not found", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeToFile() {
        try(FileOutputStream fileOut = new FileOutputStream("users.json")) {
            fileOut.write(gson.toJson(usersData).getBytes());
            fileOut.flush();
        }
        catch (IOException e) {
            throw new RuntimeException("Can't write to file");
        }
    }

    static void saveNewUser(User user){
        usersData.put(user.getEmail(), user);
        writeToFile();
    }

    static void updateUser(User user){
        usersData.put(user.getEmail(), user);
        writeToFile();
    }

    static void deleteUser(User user){
        usersData.remove(user.getEmail(), user);
        writeToFile();
    }

    public static Map<String, User> getUsersData(){
        return usersData;
    }


    private static void readUsersData() {
        try{
            String result = new String(Files.readAllBytes(Paths.get("./users.json")));
            Map<String,User> map = gson.fromJson(result, new TypeToken<HashMap<String, User>>() {}.getType());
            if(map != null){
                usersData = map;
            }
        }
        catch (IOException e) {
            throw new RuntimeException("Can't read from file");
        }
    }
}
