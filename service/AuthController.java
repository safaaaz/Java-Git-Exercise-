package service;

import service.AuthService;
import service.User;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthController {
    AuthService authService;

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
