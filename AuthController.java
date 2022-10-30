import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthController {

    private final String regexEmail = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";

    public boolean validateUserInput(User user){
        return isValidUserId(user.getId()) && isValidUserEmail(user.getEmail())
                && isValidUserName(user.getName()) && isValidPassword(user.getPassword());
    }


    private boolean isValidUserId(int id){
        if (id < 0) {
            throw new IllegalArgumentException("Id invalid");
        }
        return true;
    }
    private boolean isValidUserEmail(String email){
        if (!Pattern.compile(regexEmail).matcher(email).matches()) {
            throw new IllegalArgumentException("Email invalid");
        }
        return true;
    }

    private boolean isValidUserName (String name){
        String regex = "^[A-Za-z]\\w{5,29}$";
        Pattern p = Pattern.compile(regex);
        if (!p.matcher(name).matches()){
            throw new IllegalArgumentException("Name invalid");
        }
        return true;
    }

    // Function to validate the password.
    public static boolean isValidPassword(String password)
    {
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        Pattern p = Pattern.compile(regex);
        if (!p.matcher(password).matches()){
            throw new IllegalArgumentException("Password invalid");
        }
        return true;
    }
}
