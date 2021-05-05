package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Ingredient;


public class IngredientsFile {

    public void loadFromFile(ArrayList<Ingredient> ingredients) {
        ingredients.clear();
        try {
            Scanner sc = new Scanner(new File("Ingredients.txt"));
            while(sc.hasNextLine()){
                String [] data = sc.nextLine().split(":");
                ingredients.add(new Ingredient(data[0],Double.parseDouble(data[1])));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IngredientsFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveToFile(Object obj) {
    }
    
    
}
