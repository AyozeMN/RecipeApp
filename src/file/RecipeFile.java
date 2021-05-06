package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin;
import model.Category;
import model.Client;
import model.FinalCategory;
import model.Ingredient;
import model.NotFinalCategory;
import model.Recipe;
import model.User;


public class RecipeFile {

    public void saveToFile(User user, Recipe recipe){

        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("Recipes.txt");
            pw = new PrintWriter(fichero);
            if(user instanceof Client){
                pw.write(0 + ":" + user.getUserName()+ ":" + user.getPassword() + ":" + user.getEmail() + ":" + user.getPhoneNumber() + ":");
            }else{
                pw.write(1 + ":" + user.getUserName()+ ":");
            }
            pw.write(recipe.getName() + ":" + recipe.getSteps() + ":" + recipe.getPrice() + ":" + recipe.getCookTime().toString() + ":");
            for (Ingredient ingredient : recipe.getIngredients()) {
                pw.write(ingredient.getName() + "=" + ingredient.getPrice() + ",");
            }
            pw.write(":;");
            for (Category category : recipe.getCategories()) {
                if(category instanceof NotFinalCategory){
                    pw.write(((NotFinalCategory) category).toString() + ";");
                }else{
                    pw.write("-" + ((FinalCategory)category).toString());
                }
            }
            pw.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) fichero.close();
            } catch (IOException e2) {
               e2.printStackTrace();
            }
        }
    }    
    
    public ArrayList<User> loadFromFile(){
        try {
            ArrayList<User>users = new ArrayList();
            Scanner sc = new Scanner(new File("Recipes.txt"));
            User user = null;
            while(sc.hasNextLine()){
                String [] data = sc.nextLine().split(":");
                if(data[0].equals("0")){
                    user = new Client(data[1],data[2],data[3],Integer.parseInt(data[4]));
                }else{
                    user = new Admin(data[1],data[2],data[3],Integer.parseInt(data[4]));
                }
                
                ArrayList<Ingredient>ingredients = new ArrayList();
                String [] ingredientString = data[10].split(",");
                String [] ingredient;
                for (String string : ingredientString) {
                    ingredient = string.split("=");
                    ingredients.add(new Ingredient(ingredient[0], Double.parseDouble(ingredient[1])));
                }
                String [] nfCategories = data[11].split(";");
                ArrayList<Category> categories = new ArrayList();
                for (int i = 0; i < nfCategories.length -1; i++) {
                    categories.add(new NotFinalCategory(nfCategories[i]));
                }

                String [] fCategories = nfCategories[nfCategories.length-1].split("-");
                for (String category : fCategories) {
                    categories.add(new FinalCategory(category));
                }
                Recipe recipe = new Recipe(data[5], data[6], Double.parseDouble(data[7]), LocalTime.of(Integer.parseInt(data[8]), Integer.parseInt(data[9])), ingredients, categories);
                user.addRecipe(recipe);
                users.add(user);
            }
            return users;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RecipeFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
