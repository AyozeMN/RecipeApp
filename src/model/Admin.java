package model;


public class Admin extends User{
    
    public Admin(String userName, String password, String email, int phoneNumber) {
        super(userName, password, email, phoneNumber);
    }
    
    public void removeRecipeOfUser(User user, Recipe recipe){
        user.removeRecipe(recipe);
    }
    
}
