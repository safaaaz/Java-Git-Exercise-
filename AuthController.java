import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthController {

    public boolean validateUserInput(User user){
        boolean id = isValidUserId(user.getId());
        boolean email = isValidUserEmail(user.getEmail());
        boolean name = isValidUserName(user.getName());
        boolean password = isValidPassword(user.getPassword());
        if(id && email && name && password)
            return true;
        else
            return false;
        }


    private boolean isValidUserId(int id){
        if (id >0) {
            return true;
        }
        else {
            throw new IllegalArgumentException("Id invalid");
        }

    }
    private boolean isValidUserEmail(String email){
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";
        if (Pattern.compile(regexPattern).matcher(email).matches()){
            return true;
        }else {
            throw new IllegalArgumentException("Email invalid");
        }
    }

    private boolean isValidUserName (String name){
        String regex = "^[A-Za-z]\\w{5,29}$";
        Pattern p = Pattern.compile(regex);
        if (p.matcher(name).matches()){
            return true;
        }else {
            throw new IllegalArgumentException("Name invalid");
        }
    }

    // Function to validate the password.
    public static boolean isValidPassword(String password)
    {
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        Pattern p = Pattern.compile(regex);
        if (p.matcher(password).matches()){
            return true;
        }else {
            throw new IllegalArgumentException("Password invalid");
        }
    }
}
