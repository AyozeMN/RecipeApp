package model;

import java.util.ArrayList;

/**
 *
 * @author Ayoze, Cristina
 */
public class NotFinalCategory {
    ArrayList<Category> subCategories;
    
    void addSubCategories(Category category) {
        subCategories.add(category);
    }
}
