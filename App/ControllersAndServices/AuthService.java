package App.ControllersAndServices;

import App.Utils.Utility;

import java.util.HashMap;
import java.util.Map;

public class AuthService {

    //key = token, value = email
    private Map<String,String> tokens;
    private static AuthService singaleInistance = null;


    AuthService() {
        this.tokens = new HashMap<>();
        UserRepo.initUserRepo();
    }

    String validateUserLogin(String userEmail, String userPassword) {
        Map<String, User> usersData = UserRepo.getUsersData();
        if(usersData.get(userEmail) != null)
            if(usersData.get(userEmail).getPassword().equals(userPassword)){
                String token = Utility.RandomString(5);
                tokens.put(token,userEmail);
                System.out.println("The user has logged in successfully:)");
                return token;}
        throw new IllegalArgumentException("Email or password is illegal!!");
    }
    String validateUserRegister(User user) {
        Map<String,User> usersData = UserRepo.getUsersData();
        if(!usersData.isEmpty()) {
            if (usersData.get(user.getEmail()) == null) {
                    UserRepo.saveNewUser(user);
                    System.out.println("The user has registered successfully");
                    return validateUserLogin(user.getEmail(), user.getPassword());
            }
            else{
                throw new IllegalArgumentException("Email has been used!");
            }
        }
        else{
            UserRepo.saveNewUser(user);
            return validateUserLogin(user.getEmail(), user.getPassword());
        }
    }
    static AuthService getInstance(){
        if(singaleInistance==null)
            singaleInistance = new AuthService();
        return singaleInistance;
    }

    public Map<String, String> getTokens() {
        return tokens;
    }
}
