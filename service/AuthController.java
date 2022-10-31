package service;

import service.AuthService;
import service.User;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthController {
    AuthService authService;

<<<<<<< HEAD:AuthController.java
    Utils utils = new Utils();

    public boolean validateUserInput(User user){

        return isValidUserId(user.getId())
                && checkUserInput(user.getEmail(), utils.regexEmail, "Email invalid")
                && checkUserInput(user.getName(), utils.regexUsername, "Username invalid")
                && checkUserInput(user.getPassword(), utils.regexPassword, "Password invalid");
=======
    public AuthController() {
        this.authService = AuthService.getInstance();
    }

    public String validateUserInput(User user) throws FileNotFoundException {
        String regexEmail = "^(.+)@(.+)$";
        String regexUsername = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
        String regexPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

        if( isValidUserId(user.getId())
                && checkUserInput(user.getEmail(), regexEmail, "Email invalid")
                && checkUserInput(user.getName(), regexUsername, "Username invalid")
                && checkUserInput(user.getPassword(), regexPassword, "Password invalid")){
            return authService.validateUserRegister(user);
        }

        return null;
>>>>>>> 8fe8343bd54a794d0c7a491804a3e87a921145d0:service/AuthController.java
    }

    private boolean isValidUserId(int id){
        if (id < 0) {
            throw new IllegalArgumentException("Id invalid");
        }
        return true;
    }

    private boolean checkUserInput(String userInput ,String regex ,String message){
        if (!Pattern.compile(regex).matcher(userInput).matches()){
            throw new IllegalArgumentException(message);
        }
        return true;
    }

}
