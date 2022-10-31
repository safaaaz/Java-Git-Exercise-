package service;

import java.util.Map;

public class UserService {
    Map<String, User> map;

    public UserService(Map<String, User> map) {
        this.map = map;
    }

    protected User deleteUser(String userEmail){
        User userExists = map.get(userEmail);
        if (userEmail == null)
            throw new IllegalArgumentException("User doesn't exists");
        else
            return userExists;
    }


}
