package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Recipe;
import model.User;


public class ValorationsFile {
 
    public void loadFromFile(ArrayList<User>users){
        for (User user : users) {
            for (Recipe recipe : user.getRecipes()) {
                recipe.getValorations().clear();
            }
        }
        try {
            Scanner sc = new Scanner(new File("Valorations.txt"));
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(!line.equals("")){
                    String[] split = line.trim().split(":");
                    for (User user : users) {
                        if(user.getUserName().equals(split[1])){
                            if(user.getRecipeByName(split[0]) != null){
                                user.getRecipeByName(split[0]).setValorations(Integer.parseInt(split[2]));
                            }

                        }
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ValorationsFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveToFile(String recipeName, String userName, int valoration){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {    
            fichero = new FileWriter("Valorations.txt",true);
            pw = new PrintWriter(fichero);
            pw.write("\n");
            pw.write(recipeName + ":" + userName + ":" + valoration);
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) fichero.close();
            } catch (IOException e2) {
               e2.printStackTrace();
            }
        }
    }
    
    
}
