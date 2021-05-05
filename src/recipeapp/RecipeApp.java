package recipeapp;

import file.CategoriesFile;
import file.IngredientsFile;
import file.NotFinalCategoryFile;
import file.UsersFile;
import gui.AppForm;
import java.util.ArrayList;
import model.Client;

public class RecipeApp {
    
    public static void main(String[] args) {
        AppForm appForm = new AppForm();
        appForm.setVisible(true);
        appForm.setLocationRelativeTo(null);
        
        IngredientsFile ingredientsFile = new IngredientsFile();
        CategoriesFile categoriesFile = new CategoriesFile();
        NotFinalCategoryFile notFinalCategoryFile = new NotFinalCategoryFile();
        UsersFile usersFile = new UsersFile();
        
        appForm.ingredientsFile = ingredientsFile;
        appForm.categoriesFile = categoriesFile;
        appForm.notFinalCategoryFile = notFinalCategoryFile;
        appForm.usersFile = usersFile;
    }
    
    
}
