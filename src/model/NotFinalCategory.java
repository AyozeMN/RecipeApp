package model;

import java.util.ArrayList;

/**
 *
 * @author Ayoze, Cristina
 */
public class NotFinalCategory extends Category{
    ArrayList<Category> subCategories;

    public NotFinalCategory(String name) {
        super(name);
        this.subCategories = new ArrayList();
    }
    
    void addSubCategories(Category category) {
        subCategories.add(category);
    }
}
