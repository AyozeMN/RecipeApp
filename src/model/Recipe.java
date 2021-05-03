package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Ayoze, Cristina
 */
public class Recipe {
    String name;
    String steps;
    double price;
    LocalDate cookTime;
    ArrayList<Double> valorations;
    ArrayList<Ingredient> ingredients;
    ArrayList<FinalCategory> categories;

    public Recipe(String name, String steps, double price, LocalDate cookTime, ArrayList<Ingredient> ingredients, ArrayList<FinalCategory> categories) {
        this.name = name;
        this.steps = steps;
        this.price = price;
        this.cookTime = cookTime;
        this.ingredients = ingredients;
        this.categories = categories;
        this.valorations = new ArrayList();
    }
    
}
