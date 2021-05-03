package model;

import java.util.ArrayList;

/**
 *
 * @author Ayoze, Cristina
 */
public class Menu {
    ArrayList<Recipe> recipes;

    public Menu() {
        this.recipes = new ArrayList();
    }
    
    void addRecipesToMenu(Recipe recipe) {
        recipes.add(recipe);
    }
}
