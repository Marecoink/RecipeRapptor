
import java.util.Scanner;

public class UserInterface {

    RecipeBase recipes;
    Scanner scanner;

    public UserInterface() {
        this.recipes = new RecipeBase();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("File to read: ");
        this.recipes.fileToRecipe(scanner.nextLine());
        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");

        OUTER:
        while (true) {
            System.out.println("\nEnter command : ");
            String command = scanner.nextLine();
            switch (command) {
                case "stop":
                    break OUTER;
                case "list":
                    this.recipes.printRecipes();
                    break;
                case "find name":
                    System.out.println("Searched word: ");
                    command = scanner.nextLine();
                    System.out.println("\nRecipes: ");
                    this.recipes.findByName(command);
                    break;
                case "find cooking time":
                    System.out.println("Max cooking time: ");
                    command = scanner.nextLine();
                    System.out.println("\nRecipes: ");
                    this.recipes.findByTime(Integer.valueOf(command));
                    break;
                case "find ingredient":
                    System.out.println("Ingredient: ");
                    command = scanner.nextLine();
                    System.out.println("\nRecipes: ");
                    this.recipes.findByIngredients(command);
                    break;
                default:
                    break;
            }
        }
    }

}
