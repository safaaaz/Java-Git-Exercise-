package service;

import java.io.FileNotFoundException;

public class Client {
    public static void main(String[] args) {
        /*
        //testing
        String token1 = new AuthController().validateUserInput(new User(1,"zcxcxz@gmail.com","blablabla","S#222safa"));
        String token2 = new AuthController().validateUserInput(new User(2,"adasd@gmail.com","blablabla","S#222safa"));
        String token3 = new AuthController().validateUserInput(new User(3,"sdfxzv@gmail.com","blablabla","S#222safa"));
        String token4 = new AuthController().validateUserInput(new User(4,"retw@gmail.com","blablabla","S#222safa"));*/

        new AuthController().createNewUser("safaa","safaa@gmail.com","Ssafa123#");
        String token = new AuthController().userLogin("safaa@gmail.com","Ssafa123#");
        String email = "safaa@gmail.com";
        UserController userController = new UserController();
        //userController.updateUserEmail(token,email,"shai@gmail.com");
        //userController.updateUserPassword(token,email,"sa#S123");
        //userController.updateUserName(token,email,"yael");
        //userController.deleteUser(token,email);

        //duplicate
        //String token5 = new AuthController().validateUserInput(new User(5,"retw@gmail.com","blablabla","S#222safa"));
    }
}
