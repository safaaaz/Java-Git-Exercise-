public class AuthController {

    public boolean validateUserInput(User user){
        boolean id = validUserId(user.getId());
        boolean email = validUserEmail(user.getEmail());
        if(id)
            return true;
        }


    private boolean validUserId(int id){
        try {
            if (id >0)
                return true;
        }catch (IllegalArgumentException e){
            System.out.println("Error message: " + e.getMessage());
        }
    }
    private boolean validUserEmail(){

    }

    private boolean valid
}
