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
    }

    public void loadFromFile(ArrayList<FinalCategory> categories) {
        categories.clear();
        try {
            Scanner sc = new Scanner(new File("Categories.txt"));
            while(sc.hasNextLine()){
                categories.add(new FinalCategory(sc.nextLine()));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CategoriesFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
