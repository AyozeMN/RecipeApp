package model;

import java.util.ArrayList;

/**
 *
 * @author Ayoze, Cristina
 */
public class Menu {
    ArrayList<Recipe> recipes;
    
    void addRecipesToMenu(Recipe recipe) {
        recipes.add(recipe);
    }
}
