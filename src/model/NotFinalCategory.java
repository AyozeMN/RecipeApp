package model;

import java.util.ArrayList;

/**
 *
 * @author Ayoze, Cristina
 */
public class NotFinalCategory {
    ArrayList<Category> subCategories;

    public NotFinalCategory() {
        this.subCategories = new ArrayList();
    }
    
    void addSubCategories(Category category) {
        subCategories.add(category);
    }
}
