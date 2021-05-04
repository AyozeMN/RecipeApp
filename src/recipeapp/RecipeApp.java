
package recipeapp;

import file.IngrediensFile;
import gui.AppForm;
import java.util.ArrayList;
import model.Ingredient;


public class RecipeApp {
    
    public static void main(String[] args) {
        AppForm appForm = new AppForm();
        appForm.setVisible(true);
        appForm.setLocationRelativeTo(null);
        
        IngrediensFile file = new IngrediensFile();
        ArrayList<Ingredient> ingredients = new ArrayList();
        file.loadFromFile(ingredients);
        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient.toString());
        }
    }
    
}
