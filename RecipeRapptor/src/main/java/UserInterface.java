
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

        while (true) {
            System.out.println("\nEnter command : ");
            String command = scanner.nextLine();
            if (command.equals("stop")) {
                break;
            } else if (command.equals("list")) {
                this.recipes.printRecipes();
            } else if (command.equals("find name")) {
                System.out.println("Searched word: ");
                command = scanner.nextLine();
                System.out.println("\nRecipes: ");
                this.recipes.findByName(command);
            } else if (command.equals("find cooking time")) {
                System.out.println("Max cooking time: ");
                command = scanner.nextLine();
                System.out.println("\nRecipes: ");
                this.recipes.findByTime(Integer.valueOf(command));
            } else if (command.equals("find ingredient")) {
                System.out.println("Ingredient: ");
                command = scanner.nextLine();
                System.out.println("\nRecipes: ");
                this.recipes.findByIngredients(command);
            }

        }
    }

}
