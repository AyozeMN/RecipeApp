package model;

import java.util.ArrayList;

public class Menu {
    ArrayList<Recipe> recipes;

    public Menu() {
        this.recipes = new ArrayList();
    }
    
    public void addRecipesToMenu(Recipe recipe) {
        recipes.add(recipe);
    }
}
