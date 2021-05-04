package model;

import java.util.ArrayList;

public class Ingredient {
    private String name;
    private double price;

    public Ingredient(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ingredient{" + "name=" + name + ", price=" + price + '}';
    }

    
}
