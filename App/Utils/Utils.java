package App.Utils;

public class Utils {
    public static String regexEmail = "^(.+)@(.+)$";
    public static String regexUsername = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
    public static String regexPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";


    public static String invalidMail = "Email Invalid - email must contain '@'.";
    public static String invalidUsername = "Username Invalid";
    public static String invalidPassword = "Password Invalid - must contains at least: 1 lower, 1 upper, 1 special, 1 number and minimum length of 8 ";
    public static String invalidId = "Id Invalid";


}
