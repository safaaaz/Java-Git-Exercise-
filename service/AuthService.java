package service;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class AuthService {

    //key = token, value = email
    private Map<String,String> tokens;
    private static AuthService singaleInistance=null;

    public AuthService() {
        this.tokens = new HashMap<>();
    }

    public String validateUserLogin(String userEmail, String userPassword) {
        Map<String,User> usersData = UserRepo.getUsersData();
        if(usersData.get(userEmail) != null)
            if(usersData.get(userEmail).getPassword().equals(userPassword))
                return "token";//save token to user in tokens and return it
        return null;
    }
    public String validateUserRegister(User user) {
        Map<String,User> usersData = UserRepo.getUsersData();
        if(usersData.get(user.getEmail())!=null)
            if(usersData.get(user.getEmail()).getEmail().equals(user.getEmail())){
                UserRepo.saveNewUser(user);
                return validateUserLogin(user.getEmail(), user.getPassword());
            }
        throw new RuntimeException("Id or Email has been used!");

    }
    public static AuthService getInstance(){
        if(singaleInistance==null)
            singaleInistance = new AuthService();
        return singaleInistance;
    }

}
