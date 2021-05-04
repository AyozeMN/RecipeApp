
package recipeapp;

import file.CategoriesFile;
import file.IngredientsFile;
import gui.AppForm;
import java.util.ArrayList;
import model.Client;
import model.Ingredient;
import model.User;


public class RecipeApp {
    
    public static void main(String[] args) {
        AppForm appForm = new AppForm();
        appForm.setVisible(true);
        appForm.setLocationRelativeTo(null);
        
        ArrayList<User>users = new ArrayList();
        users.add(new Client(0, "prueba", "prueba", "prueba@mail.com", 666666666));
        
        IngredientsFile ingredientsFile = new IngredientsFile();
        CategoriesFile categoriesFile = new CategoriesFile();
        ArrayList<Ingredient> ingredients = new ArrayList();
        
        appForm.ingredientsFile = ingredientsFile;
        appForm.categoriesFile = categoriesFile;
        appForm.users = users;
        
        
    }
    
}
