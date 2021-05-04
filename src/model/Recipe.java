package model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Recipe {
    String name;
    String steps;
    double price;
    LocalTime cookTime;
    ArrayList<Double> valorations;
    ArrayList<Ingredient> ingredients;
    ArrayList<FinalCategory> categories;

    public Recipe(String name, String steps, double price, LocalTime cookTime, ArrayList<Ingredient> ingredients, ArrayList<FinalCategory> categories) {
        this.name = name;
        this.steps = steps;
        this.price = price;
        this.cookTime = cookTime;
        this.ingredients = ingredients;
        this.categories = categories;
        this.valorations = new ArrayList();
    }

    @Override
    public String toString() {
        return name + ", steps=" + steps + ", price=" + price + ", cookTime=" + cookTime + ", valorations=" + valorations + ", ingredients=" + ingredients + ", categories=" + categories + "\n";
    }
    
}
