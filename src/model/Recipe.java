package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

public class Recipe {
    String name;
    String steps;
    double price;
    LocalTime cookTime;
    ArrayList<Integer> valorations;
    ArrayList<Ingredient> ingredients;
    ArrayList<Category> categories;

    public Recipe(String name, String steps, double price, LocalTime cookTime, ArrayList<Ingredient> ingredients, ArrayList<Category> categories) {
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

    public ArrayList<Integer> getValorations() {
        return valorations;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public boolean containsCategory(String categoryName){
        for (Category cat : categories) {
            if(cat.getName().equals(categoryName)) return true;
        }
        return false;
    }
    
    public String getOverageRating(){
        int count = 0;
        double average = 0;
        for (Integer valoration : valorations) {
            count++;
            average += valoration;
        }
        if(count == 0) return "-";
        else return String.valueOf(average/valorations.size());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recipe other = (Recipe) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    public void setValorations(Integer valoration) {
        valorations.add(valoration);
    }

    
    
    @Override
    public String toString() {
        return name + ", steps=" + steps + ", price=" + price + ", cookTime=" + cookTime + ", valorations=" + valorations + ", ingredients=" + ingredients + ", categories=" + categories + "\n";
    }
}
