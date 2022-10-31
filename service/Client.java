package service;

import java.io.FileNotFoundException;

public class Client {
    public static void main(String[] args) throws FileNotFoundException {
        String safaaToken = new AuthController().validateUserInput(new User(2134,"safaa@gmail.com","safaa","S222safa"));

    }
}
