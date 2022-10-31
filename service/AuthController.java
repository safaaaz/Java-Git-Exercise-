package service;

import service.AuthService;
import service.User;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthController {
    AuthService authService;
    Utils utils = new Utils();

    public AuthController() {
        this.authService = AuthService.getInstance();
    }

    public String validateUserInput(User user) throws FileNotFoundException {
        if(isValidUserId(user.getId())
                && checkUserInput(user.getEmail(), utils.regexEmail, utils.invalidMail)
                && checkUserInput(user.getName(), utils.regexUsername, utils.invalidUsername)
                && checkUserInput(user.getPassword(), utils.regexPassword, utils.invalidPassword)){
            return authService.validateUserRegister(user);
        }

        return null;
    }

    private boolean isValidUserId(int id){
        if (id < 0) {
            throw new IllegalArgumentException(utils.invalidId);
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
