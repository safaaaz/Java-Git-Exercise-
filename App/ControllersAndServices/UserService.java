package App.ControllersAndServices;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    Map<String, User> map;

    public UserService() {
        this.map = new HashMap<>();
    }

    private User isUser(String userEmail){
        Map<String, User> usersData = UserRepo.getUsersData();
        User userExists = usersData.get(userEmail);
        if (userEmail == null)
            throw new IllegalArgumentException("User doesn't exists");
        else
            return userExists;
    }
    void deleteUser(String userEmail){
        User userExists = isUser(userEmail);
        UserRepo.deleteUser(userExists);
    }

    User updateUserEmail(String userEmail , String newEmail){
        User userExists = isUser(userEmail);
        userExists.setEmail(newEmail);
        UserRepo.updateUserEmail(userEmail,userExists);
        return userExists;
    }
    User updateUserName(String userEmail , String userName){
        User userExists = isUser(userEmail);
        userExists.setName(userName);
        UserRepo.updateUser(userExists);
        return userExists;
    }
    User updateUserPassword(String userEmail , String userPassword){
        User userExists = isUser(userEmail);
        userExists.setPassword(userPassword);
        UserRepo.updateUser(userExists);
        return userExists;
    }
}
