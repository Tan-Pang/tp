package medistock;

import medistock.ui.Ui;

import java.util.Scanner;

public class Medistock {
    /**
     * Main entry-point for the java.medistick.Medistock application.
     */
    public static void main(String[] args) {
        Ui.greet();

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String command = in.nextLine();

            if (command.equals("exit")) {
                Ui.exit();
                break;
            }
        }
        in.close();
    }
}
