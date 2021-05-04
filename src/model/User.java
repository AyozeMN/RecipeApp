package model;

import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author Ayoze, Cristina
 */
public abstract class User {
    String userName;
    String password;
    String email;
    int phoneNumber;
    int userRole;
    ArrayList<Recipe> recipes;
    ArrayList<Menu> menus;
    
    public User(int userRole, String userName, String password, String email, int phoneNumber) {
        this.userRole = userRole;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.recipes = new ArrayList();
        this.menus = new ArrayList();
    }    

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public void addRecipe(Recipe recipe){
        recipes.add(recipe);
    }
    
    public void addMenu(Menu menu){
        menus.add(menu);
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

    public int getUserRole() {
        return userRole;
    }
    
}
