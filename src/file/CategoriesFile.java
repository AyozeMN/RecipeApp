package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FinalCategory;

public class CategoriesFile {

    public void saveToFile(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void loadFromFile(ArrayList<FinalCategory> categories) {
        categories.clear();
        try {
            Scanner sc = new Scanner(new File("Categories.txt"));
            while(sc.hasNextLine()){
                categories.add(new FinalCategory(sc.next()));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IngrediensFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
