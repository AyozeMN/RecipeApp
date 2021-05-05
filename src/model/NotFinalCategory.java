package model;

import java.util.ArrayList;

public class NotFinalCategory extends Category{
    ArrayList<FinalCategory> subCategories;

    public NotFinalCategory(String name) {
        super(name);
        this.subCategories = new ArrayList();
    }
    
    public void addSubCategories(FinalCategory finalCategory) {
        subCategories.add(finalCategory);
    }

    public ArrayList<FinalCategory> getSubCategories() {
        return subCategories;
    }
    
    @Override
    public String toString() {
        return super.name;
    }
    
    
}
