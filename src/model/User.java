package model;

import java.awt.Image;

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
    Image profileImage;

    //Sin imagen
    public User(int id, String userName, String password, String email, int phoneNumber, int userRole) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userRole = userRole;
    }

    //Con imagen
    public User(int id, String userName, String password, String email, int phoneNumber, int userRole, Image profileImage) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userRole = userRole;
        this.profileImage = profileImage;
    }
}
