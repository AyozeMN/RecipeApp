package model;

import java.util.ArrayList;

/**
 *
 * @author Ayoze, Cristina
 */
public class FinalCategory extends Category {
    ArrayList<Ingredient> ingredients;
    
    void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }
}
