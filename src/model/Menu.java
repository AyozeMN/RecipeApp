package model;

import java.util.ArrayList;

public class Menu {
    ArrayList<Recipe> recipes;

    private String name;
    
    public Menu(String name) {
        this.name = name;
        this.recipes = new ArrayList();
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public String getName() {
        return name;
    }
    
    public void addRecipesToMenu(Recipe recipe) {
        recipes.add(recipe);
    }

    @Override
    public String toString() {
        return "Menu " + name + ": \n" + recipes;
    }
    
    
}
