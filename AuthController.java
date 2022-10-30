import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthController {

    public boolean validateUserInput(User user){
        boolean id = isValidUserId(user.getId();
        boolean email = isValidUserEmail(user.getEmail());
        boolean name = isValidUserName(user.getName());
        boolean password = isValidPassword(user.getPassword());
        if(id && email && name && password)
            return true;
        }


    private boolean isValidUserId(int id){
        try {
            if (id >0)
                return true;
        }catch (IllegalArgumentException e){
            System.out.println("Error message: " + e.getMessage());
        }
    }
    private boolean isValidUserEmail(String email){
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern).matcher(email).matches();
    }

    private boolean isValidUserName (String name){
        // Regex to check valid username.
        String regex = "^[A-Za-z]\\w{5,29}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the username is empty
        // return false
        if (name == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given username
        // and regular expression.
        Matcher m = p.matcher(name);

        // Return if the username
        // matched the ReGex
        return m.matches();
    }

    // Function to validate the password.
    public static boolean isValidPassword(String password)
    {

        // Regex to check valid password.
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the password is empty
        // return false
        if (password == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(password);

        // Return if the password
        // matched the ReGex
        return m.matches();
    }
}
