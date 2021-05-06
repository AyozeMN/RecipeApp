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

    public void addRecipe(Recipe recipe){
        recipes.add(recipe);
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
    
    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    
}
