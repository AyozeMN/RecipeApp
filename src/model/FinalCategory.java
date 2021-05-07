package model;

import java.util.ArrayList;

public class FinalCategory extends Category {
    ArrayList<Ingredient> ingredients;
    ArrayList<Recipe> recipes;

    public FinalCategory(String name) {
        super(name);
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
