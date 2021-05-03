package model;

import java.util.ArrayList;

/**
 *
 * @author Ayoze, Cristina
 */
public class FinalCategory extends Category {
    ArrayList<Ingredient> ingredients;
    ArrayList<Recipe> recipes;

    public FinalCategory() {
        this.ingredients = new ArrayList();
        this.recipes = new ArrayList();
    }
    
    void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }
    
    void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }
}
