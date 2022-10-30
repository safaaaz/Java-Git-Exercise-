import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthController {

    public boolean validateUserInput(User user){
        String regexEmail = "^(.+)@(.+)$";
        String regexUsername = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
        String regexPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

        return isValidUserId(user.getId())
                && checkUserInput(user.getEmail(), regexEmail, "Email invalid")
                && checkUserInput(user.getName(), regexUsername, "Username invalid")
                && checkUserInput(user.getPassword(), regexPassword, "Password invalid");
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
