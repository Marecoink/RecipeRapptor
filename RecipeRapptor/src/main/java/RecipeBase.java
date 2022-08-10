
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class RecipeBase {

    private ArrayList<Recipe> recipes;

    public RecipeBase() {
        this.recipes = new ArrayList<>();
    }

    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }

    public Recipe getRecipe(int index) {
        return this.recipes.get(index);
    }

    public void fileToRecipe() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String fileName = scanner.nextLine();
            if (fileName.equals("end")) {
                System.exit(0);
            }
            try (Scanner fileCheck = new Scanner(Paths.get(fileName))) {
                while (fileCheck.hasNextLine()) {
                    String row = fileCheck.nextLine();
                    list.add(row);
                    //System.out.println(row);
                }
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("File doesnt exist. Type \"end\" to exit or try another file:");
            }

        }
        //  System.out.println(list);
        String name = "";
        int time = 0;
        int index = 0;
        ArrayList<String> ingr = new ArrayList<>();
        for (String line : list) {
            if (index == 0) {
                name = line;
                index = 1;
                continue;
            }
            if (index == 1) {

                time = Integer.valueOf(line);
                index = 2;
                continue;
            }
            if (line.isEmpty() || line.equals(list.get(list.size() - 1))) {
                if (line.equals(list.get(list.size() - 1))) {
                    ingr.add(line);
                }
                Recipe recipe = new Recipe(name, time, ingr);
                this.recipes.add(recipe);
                index = 0;
                ingr = new ArrayList<>();
            } else {
                ingr.add(line);
                index++;
            }
        }
    }

    public void findByName(String name) {
        for (Recipe recipe : this.recipes) {
            if (recipe.getName().contains(name)) {
                System.out.println(recipe);
            }
        }
    }

    public void findByTime(int time) {
        for (Recipe recipe : this.recipes) {
            if (recipe.getTime() <= time) {
                System.out.println(recipe);
            }
        }
    }

    public void findByIngredients(String name) {
        for (Recipe recipe : this.recipes) {
            ArrayList<String> recipeIngredients = recipe.getIngredients();
            for (String ingredient : recipeIngredients) {
                if (ingredient.equals(name)) {
                    System.out.println(recipe);
                }
            }
        }
    }

    public void printRecipes() {
        for (Recipe recipe : recipes) {
            System.out.println(recipe);
        }
    }

    public void addRecipeToFile() {
        Scanner scanner = new Scanner(System.in);
        String path = System.getProperty("user.dir") + "\\recipes.txt";
        System.out.println("Recipe name:");
        String newRecipeName = scanner.nextLine(); //name cant be empty - to add
        addingToFile(path, newRecipeName);
        System.out.println("Cooking time(in minutes):");  //time cant be empty, must be integer - to add
        String newRecipeCookTime = scanner.nextLine();
        addingToFile(path, newRecipeCookTime);
        int count = 0;
        while (true) {
            System.out.println("Add ingredients(write empty line after last ingredient):");
            String newRecipeIngredient = scanner.nextLine();
            if (newRecipeIngredient.isEmpty() && count == 0) {
                System.out.println("Hey, add at least one ingredient...");
                continue;
            }
            count++;
            addingToFile(path, newRecipeIngredient);
            if (newRecipeIngredient.isEmpty()) {
                break;
            }
        }

        // System.out.println();
        ArrayList<String> list = new ArrayList<>();
        try (Scanner fileCheck = new Scanner(Paths.get("recipes.txt"))) {
            while (fileCheck.hasNextLine()) {
                String row = fileCheck.nextLine();
                list.add(row);
                //System.out.println(row);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("File doesnt exist. Type \"end\" to exit or try another file:");
        }
        System.out.println(list);
    }

    public void addingToFile(String path, String text) {
        try {
            FileWriter fw = new FileWriter(path, true);
            fw.write("\n" + text);
            fw.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
// ostatni ingredient nie moze sie powtarzac - do poprawy
//po dodaniu nowej recipe lista niech się odświeży a nie doda do istniejącej