package recipeapp;

import file.CategoriesFile;
import file.IngredientsFile;
import file.NotFinalCategoryFile;
import file.RecipeFile;
import file.UsersFile;
import gui.AppForm;
import java.util.ArrayList;
import model.Recipe;
import model.User;

public class RecipeApp {
    
    public static void main(String[] args) {
        AppForm appForm = new AppForm();
        appForm.setVisible(true);
        appForm.setLocationRelativeTo(null);
        
        IngredientsFile ingredientsFile = new IngredientsFile();
        CategoriesFile categoriesFile = new CategoriesFile();
        NotFinalCategoryFile notFinalCategoryFile = new NotFinalCategoryFile();
        UsersFile usersFile = new UsersFile();
        RecipeFile recipeFile = new RecipeFile();
        
        appForm.ingredientsFile = ingredientsFile;
        appForm.categoriesFile = categoriesFile;
        appForm.notFinalCategoryFile = notFinalCategoryFile;
        appForm.usersFile = usersFile;
        appForm.recipeFile = recipeFile;
        
        /*ArrayList<User>users = recipeFile.loadFromFile();
        for (User user : users) {
            for (Recipe recipe : user.getRecipes()) {
                System.out.println(recipe.toString());
            }
        }*/
    }
    
    
}
