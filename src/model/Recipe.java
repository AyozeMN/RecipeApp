package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Ayoze, Cristina
 */
public class Recipe {
    int id;
    String name;
    String steps;
    double price;
    LocalDate cookTime;
    ArrayList<Double> valorations;
    ArrayList<Ingredient> ingredient;
    ArrayList<FinalCategory> categories;

    public Recipe(int id, String name, String steps, double price, LocalDate cookTime, ArrayList<Ingredient> ingredient, ArrayList<FinalCategory> categories) {
        this.id = id;
        this.name = name;
        this.steps = steps;
        this.price = price;
        this.cookTime = cookTime;
        this.ingredient = ingredient;
        this.categories = categories;
        this.valorations = new ArrayList();
    }
    
}
