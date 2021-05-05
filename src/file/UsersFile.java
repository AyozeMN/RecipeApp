package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Client;

public class UsersFile {
    public void saveToFile(Object obj) {
    }

    public void loadFromFile(ArrayList<Client> clients) {
        try {
            Scanner sc = new Scanner(new File("Users.txt"));
            while(sc.hasNextLine()){
                String [] data = sc.nextLine().split(":");
                clients.add(new Client(Integer.parseInt(data[0]),data[1],data[2],data[3],Integer.parseInt(data[4])));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UsersFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
