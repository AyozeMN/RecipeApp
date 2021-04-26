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
    //ArrayList<Step> steps;
    double price;
    LocalDate cookTime;
    //ArrayList<Valoration> valorations;
    ArrayList<Ingredient> ingredient;

    public Recipe(int id, String name, double price, LocalDate cookTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cookTime = cookTime;
    }
    
}
