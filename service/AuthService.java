package service;

import java.util.Map;

public class AuthService {
    private Map<Integer,String> tokens;

    public String validateUserLogin(int userId,String userPassword){
        Map<Integer,User> usersData = getUsersData();
        if(usersData.get(userId).getPassword()!=userPassword)
            return null;
        return "token"; //to save token to user in tokens and return it
    }
    public String valideteUserRegister(User user){
        Map<Integer,User> usersData = getUsersData();
        if(usersData.get(user.id)!=null)
            if(usersData.get(user.id).getEmail()!=user.getEmail()){
                saveNewUser(user);
                return validateUserLogin(user.getId(),user.getPassword());
            }
        throw new RuntimeException("Id or Email has been used!");

    }

}
