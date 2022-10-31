package service;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    Map<String, User> map;

    public UserService() {
        this.map = new HashMap<>();
    }

    private User isUser(String userEmail){
        User userExists = map.get(userEmail);
        if (userEmail == null)
            throw new IllegalArgumentException("User doesn't exists");
        else
            return userExists;
    }
    protected User deleteUser(String userEmail){
        User userExists = isUser(userEmail);
        return map.remove(userEmail);
    }

    protected User updateUserEmail(String userEmail , String newEmail){
        User userExists = isUser(userEmail);
        userExists.setEmail(userEmail);
        return userExists;
    }
    protected User updateUserName(User user , String userName){
        User userExists = isUser(user.getEmail());
        user.setName(userName);
        return user;
    }
    protected User updateUserPassword(User user , String userPassword){
        User userExists = isUser(user.getEmail());
        user.setPassword(userPassword);
        return user;
    }
}
