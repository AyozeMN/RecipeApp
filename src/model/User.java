package model;

import java.util.ArrayList;

public abstract class User {
    String userName;
    String password;
    String email;
    int phoneNumber;
    ArrayList<Recipe> recipes;
    ArrayList<Menu> menus;
    
    public User(String userName, String password, String email, int phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.recipes = new ArrayList();
        this.menus = new ArrayList();
    }    

    public boolean addRecipe(Recipe recipe){
        for (Recipe recipe1 : recipes) {
           if(recipe1.equals(recipe)) {
               return false;
           }
        }
        recipes.add(recipe);
        return true;
    }
    
    public void removeRecipe(Recipe recipe){
        recipes.remove(recipe);
    }
    
    public void addMenu(Menu menu){
        menus.add(menu);
    }
    
    public void removeMenu(Menu menu){
        menus.remove(menu);
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }
    
    public Recipe getRecipe(Recipe recipe){
        for (Recipe recipe1 : recipes) {
            if(recipe1.equals(recipe))
                return recipe1;
        }
        return null;
    }
    
    public Recipe getRecipeByName(String name) {
        for (Recipe recipe1 : recipes) {
            if(recipe1.getName().equals(name))
                return recipe1;
        }
        return null;
    }
    
    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
    
    public boolean isMyOwnRecipe(User user,Recipe recipe/*, int valoration*/){
        if(getRecipe(recipe) == null){ //este usuario no la tiene
            return false; //la receta no es mía
        }
        return true; //la receta es mía
    }

    
}
