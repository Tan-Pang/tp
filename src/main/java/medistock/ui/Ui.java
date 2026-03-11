package medistock.ui;

import medistock.inventory.InventoryItem;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Handles all user interactions including input and output.
 */
public class Ui {

    public static final String EXIT_MESSAGE = "Thank you for using medistock!";
    public static final String WELCOME_MESSAGE = "Welcome to medistock";
    private final Scanner scanner;

    /**
     * Creates an Ui instance with a Scanner for reading user input.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Reads the next command from the user. Returns the full string entered into the console.
     *
     * @return The user's input line.
     */
    public String getInput() {
        return scanner.nextLine();
    }


    /**
     * Reads a command from the user.
     *
     * @return The user's input as a trimmed string.
     */
    public String readCommand() {
        return scanner.nextLine().trim();
    }

    public static void printLine() {
        System.out.println("____________________________________________________________");
    }

    public static void greet() {
        printLine();
        System.out.println(WELCOME_MESSAGE);
        printLine();
    }

    public static void exit() {
        printLine();
        System.out.println(EXIT_MESSAGE);
        printLine();
    }

    /**
     * Prints an error message.
     *
     * @param e the error message printed
     */
    public void printError(String e) {
        printLine();
        System.out.println("Invalid Input: " + e);
        printLine();
    }

    public void printExit() {
        System.out.println("Inventory saved");
        System.out.println("Thank you for using MediStock, have a nice day!");
    }

    public static void printCreate(String name, String unit, int minimumThreshold) {
        printLine();
        System.out.println(String.format("Product created:\n" + name + " (" + unit + ")\n" + "Minimum threshold: "
                        + minimumThreshold));
        printLine();
    }

    public static void printItemDetails(InventoryItem item) {
        String name = item.getName();
        System.out.println(name);
    }

    public static void printBatch(int quantity, InventoryItem item, LocalDate date) {
        System.out.println(String.format("Batch of %d %s, expiring on %3$tF has been successfully added!", quantity,
                        item.getName(), date));
        printLine();
        printItemDetails(item);
        printLine();
    }

}
