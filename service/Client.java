package service;

import java.io.FileNotFoundException;

public class Client {
    public static void main(String[] args) {
        //testing
        String token1 = new AuthController().validateUserInput(new User(1,"zcxcxz@gmail.com","blablabla","S#222safa"));
        String token2 = new AuthController().validateUserInput(new User(2,"adasd@gmail.com","blablabla","S#222safa"));
        String token3 = new AuthController().validateUserInput(new User(3,"sdfxzv@gmail.com","blablabla","S#222safa"));
        String token4 = new AuthController().validateUserInput(new User(4,"retw@gmail.com","blablabla","S#222safa"));
        //duplicate
        //String token5 = new AuthController().validateUserInput(new User(5,"retw@gmail.com","blablabla","S#222safa"));
    }
}
