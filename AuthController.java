import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthController {

    Utils utils = new Utils();

    public boolean validateUserInput(User user){

        return isValidUserId(user.getId())
                && checkUserInput(user.getEmail(), utils.regexEmail, "Email invalid")
                && checkUserInput(user.getName(), utils.regexUsername, "Username invalid")
                && checkUserInput(user.getPassword(), utils.regexPassword, "Password invalid");
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
