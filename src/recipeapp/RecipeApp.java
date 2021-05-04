
package recipeapp;

import file.CategoriesFile;
import file.IngredientsFile;
import gui.AppForm;
import java.util.ArrayList;
import model.Ingredient;


public class RecipeApp {
    
    public static void main(String[] args) {
        AppForm appForm = new AppForm();
        appForm.setVisible(true);
        appForm.setLocationRelativeTo(null);
        
        IngredientsFile ingredientsFile = new IngredientsFile();
        CategoriesFile categoriesFile = new CategoriesFile();
        ArrayList<Ingredient> ingredients = new ArrayList();
        
        appForm.ingredientsFile = ingredientsFile;
        appForm.categoriesFile = categoriesFile;
        
        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient.toString());
        }
    }
    
}
