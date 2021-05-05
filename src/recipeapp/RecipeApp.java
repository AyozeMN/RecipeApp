
package recipeapp;

import file.CategoriesFile;
import file.IngredientsFile;
import file.NotFinalCategoryFile;
import gui.AppForm;
import java.util.ArrayList;
import model.Client;
import model.User;


public class RecipeApp {
    
    public static void main(String[] args) {
        AppForm appForm = new AppForm();
        appForm.setVisible(true);
        appForm.setLocationRelativeTo(null);
        
        ArrayList<User>users = new ArrayList();
        users.add(new Client(0, "prueba", "prueba", "prueba@mail.com", 666666666));
        users.add(new Client(0, "", "", "@mail.com", 666666667));
        
        IngredientsFile ingredientsFile = new IngredientsFile();
        CategoriesFile categoriesFile = new CategoriesFile();
        NotFinalCategoryFile notFinalCategoryFile = new NotFinalCategoryFile();
        
        appForm.ingredientsFile = ingredientsFile;
        appForm.categoriesFile = categoriesFile;
        appForm.notFinalCategoryFile = notFinalCategoryFile;
        appForm.users = users;
        
        
    }
    
}
