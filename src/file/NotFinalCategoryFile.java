package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FinalCategory;
import model.NotFinalCategory;

public class NotFinalCategoryFile {
    public void saveToFile(Object obj) {
    }

    public void loadFromFile(ArrayList<NotFinalCategory> categories) {
        categories.clear();
        try {
            Scanner sc = new Scanner(new File("NotFinalCategories.txt"));
            int idx = 0;
            while(sc.hasNextLine()){
                String [] data = sc.nextLine().split(":");
                categories.add(new NotFinalCategory(data[0]));
                if(data.length > 1) {
                    String [] dataSub = data[1].split(",");
                    for (String subCat : dataSub) {
                        categories.get(idx).addSubCategories(new FinalCategory(subCat));
                    }
                }
                idx++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NotFinalCategoryFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
