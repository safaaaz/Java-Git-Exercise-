package service;

import java.util.InputMismatchException;
import java.util.Map;

public class AuthService {
    private Map<String,User> tokens;

    public String validateUserLogin(int userId,String userPassword){
        Map<Integer,User> usersData = UserRepo.getUsersData();
        if(usersData.get(userId)!=null)
            if(usersData.get(userId).getPassword()==userPassword)
                return "token";//save token to user in tokens and return it
        return null;
    }
    public String validateUserRegister(User user){
        Map<Integer,User> usersData = UserRepo.getUsersData();
        if(usersData.get(user.getId())!=null)
            if(usersData.get(user.getId()).getEmail()!=user.getEmail()){
                UserRepo.saveNewUser(user);
                return validateUserLogin(user.getId(),user.getPassword());
            }
        throw new RuntimeException("Id or Email has been used!");

    }

}
