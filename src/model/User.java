package model;

import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author Ayoze, Cristina
 */
public class User {
    int id;
    String userName;
    String password;
    String email;
    int phoneNumber;
    int userRole;
    ArrayList<Recipe> recipes;
    ArrayList<Menu> menus;

    //Sin imagen
    public User(int id, String userName, String password, String email, int phoneNumber, int userRole) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userRole = userRole;
        this.recipes = new ArrayList();
        this.menus = new ArrayList();
    }    
    
}
