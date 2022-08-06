
import java.util.ArrayList;

public class Recipe {

    private String recipeName;
    private int cookingTime;
    private ArrayList<String> ingredients;

    public Recipe(String name, int time, ArrayList<String> ingridients) {
        this.recipeName = name;
        this.cookingTime = time;
        this.ingredients = ingridients;
    }

    public String getName() {
        return this.recipeName;
    }

    public int getTime() {
        return this.cookingTime;
    }

    public ArrayList getIngredients() {
        return this.ingredients;
    }

    @Override
    public String toString() {
        return "" + this.recipeName + ", cooking time: " + this.cookingTime/* + " (ingr test): " + this.ingredients*/;
    }

}
