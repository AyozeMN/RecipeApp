package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin;
import model.Client;
import model.User;

public class UsersFile {

    public void loadFromFile(ArrayList<User> users) {
        try {
            Scanner sc = new Scanner(new File("Users.txt"));
            boolean isAlreadyCreated = false;
            while(sc.hasNextLine()){
                String [] data = sc.nextLine().split(":");
                for (User user : users) {
                    if(data[1].equals(user.getUserName())) isAlreadyCreated = true;
                }
                if(!isAlreadyCreated){
                    if(Integer.parseInt(data[0]) == 1) users.add(new Admin(data[1],data[2],data[3],Integer.parseInt(data[4])));
                    else users.add(new Client(data[1],data[2],data[3],Integer.parseInt(data[4])));
                }
                isAlreadyCreated = false;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UsersFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
