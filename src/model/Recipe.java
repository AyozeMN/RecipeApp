package model;

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

    public String getName() {
        return name;
    }

    public String getSteps() {
        return steps;
    }

    public double getPrice() {
        return price;
    }

    public LocalTime getCookTime() {
        return cookTime;
    }

    public ArrayList<Double> getValorations() {
        return valorations;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public ArrayList<FinalCategory> getCategories() {
        return categories;
    }

    public boolean containsCategory(String categoryName){
        for (FinalCategory cat : categories) {
            if(cat.getName().equals(categoryName)) return true;
        }
        return false;
    }
    
    public double getOverageRating(){
        double overage = 0;
        for (Double valoration : valorations) {
            overage += valoration;
        }
        return overage/valorations.size();
    }
    
    @Override
    public String toString() {
        return name + ", steps=" + steps + ", price=" + price + ", cookTime=" + cookTime + ", valorations=" + valorations + ", ingredients=" + ingredients + ", categories=" + categories + "\n";
    }
    
    
    
}
