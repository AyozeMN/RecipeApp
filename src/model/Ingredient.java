package model;

import java.util.ArrayList;

/**
 *
 * @author Ayoze, Cristina
 */
public class Ingredient {
    int id;
    String name;
    double price;
    ArrayList<FinalCategory> categories;

    public Ingredient(int id, String name, double price, ArrayList<FinalCategory> categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categories = categories;
    }
    
}
