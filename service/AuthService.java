package service;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class AuthService {
    private Map<String,User> tokens;
    private static AuthService singaleInistance=null;

    public AuthService() {
        this.tokens = new HashMap<>();
    }

    public String validateUserLogin(int userId, String userPassword) throws FileNotFoundException {
        Map<Integer,User> usersData = UserRepo.getUsersData();
        if(usersData.get(userId)!=null)
            if(usersData.get(userId).getPassword()==userPassword)
                return "token";//save token to user in tokens and return it
        return null;
    }
    public String validateUserRegister(User user) throws FileNotFoundException {
        Map<Integer,User> usersData = UserRepo.getUsersData();
        if(usersData.get(user.getId())!=null)
            if(usersData.get(user.getId()).getEmail()!=user.getEmail()){
                UserRepo.saveNewUser(user);
                return validateUserLogin(user.getId(),user.getPassword());
            }
        throw new RuntimeException("Id or Email has been used!");

    }
    public static AuthService getInstance(){
        if(singaleInistance==null)
            singaleInistance = new AuthService();
        return singaleInistance;
    }

}