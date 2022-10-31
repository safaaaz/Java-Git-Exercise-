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

    public String validateUserInput(User user) {
        if(isValidUserId(user.getId())
                && checkUserInput(user.getEmail(), Utils.regexEmail, Utils.invalidMail)
                && checkUserInput(user.getName(), Utils.regexUsername, Utils.invalidUsername)
                && checkUserInput(user.getPassword(), Utils.regexPassword, Utils.invalidPassword)){
            return authService.validateUserRegister(user);
        }

        return null;
    }

    private boolean isValidUserId(int id){
        if (id < 0) {
            throw new IllegalArgumentException(Utils.invalidId);
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
