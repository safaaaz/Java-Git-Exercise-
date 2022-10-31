package service;

public class Utils {
    public String regexEmail = "^(.+)@(.+)$";
    public String regexUsername = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
    public String regexPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";


    public String invalidMail = "Email Invalid";
    public String invalidUsername = "Username Invalid";
    public String invalidPassword = "Password Invalid";
    public String invalidId = "Id Invalid";


}
