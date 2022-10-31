package service;

public class UserController {
    UserController userController;

    public UserController() {
        this.userController = new UserController();
    }

    public void deleteUser(String token, String userEmail){
        if(AuthService.getInstance().getTokens().get(token)==userEmail){
            userController.deleteUser(userEmail);
            System.out.println("the user with email : "+userEmail+" deleted successfully ");
            return;
        }
        throw new IllegalArgumentException("Incorrect token or email!");
    }
    public void updateUserEmail(String token,String userEmail, String newEmail ){
        if(AuthService.getInstance().getTokens().get(token)==userEmail){
            userController.updateUserEmail(userEmail,newEmail);
            System.out.println("User email updated from "+userEmail +" to "+newEmail);
        }
        throw new IllegalArgumentException("Incorrect token or email!");
    }
}
