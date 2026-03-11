package medistock.parser;

import medistock.command.BatchCommand;
import medistock.command.Command;
import medistock.command.CreateCommand;
import medistock.command.ExitCommand;
import medistock.exception.MediStockException;

import java.time.LocalDate;

public class Parser {
    public static Command parseCommand(String input) throws MediStockException {
        String text = input.trim();

        if (text.startsWith("create ")) {
            return prepareCreate(text);
        }

        else if (text.startsWith("batch")) {
            return prepareBatch(text);
        }

        else if (text.startsWith("exit") || text.startsWith("quit")) {
            return new ExitCommand();
        }
        else  {
            throw new MediStockException("Unknown command.");
        }


    }

    /**
     * Serves as helper function, that returns the useful starting index of an input Parameter
     *

     */
    private static String getArgument(String text, int index1, int... index2) {
        if (index2.length > 0) {
            return text.substring(index1 + 2, index2[0]).trim();
        }
        else {
            return text.substring(index1+2).trim();
        }
    }

    private static String getMinimum(String text, int minIndex) {
        return text.substring(minIndex + 4).trim();
    }


    private static Command prepareBatch(String text) throws MediStockException {
        int nameIndex = text.indexOf("n/");
        int quantIndex = text.indexOf("q/");
        int expiryIndex = text.indexOf("d/");

        if (nameIndex == -1 || quantIndex == -1) {
            throw new MediStockException("Invalid batch format. Use: batch n/NAME q/QUANTITY d/EXPIRY_DATE");
        }
        if (!(nameIndex < quantIndex && quantIndex < expiryIndex)) {
            throw new MediStockException("Use batch format: batch n/NAME q/QUANTITY d/EXPIRY_DATE");
        }

        String name = getArgument(text, nameIndex, quantIndex);
        int quant = Integer.parseInt(getArgument(text, quantIndex, expiryIndex));
        LocalDate expiryDate = LocalDate.parse(getArgument(text,expiryIndex));

        return new BatchCommand(name, quant, expiryDate);
    }


    private static Command prepareCreate(String text) throws MediStockException {
        int nameIndex = text.indexOf("n/");
        int unitIndex = text.indexOf("u/");
        int minIndex = text.indexOf("min/");

        if (nameIndex == -1 || unitIndex == -1 || minIndex == -1) {
            throw new MediStockException("Invalid create format. Use: create n/NAME u/UNIT min/THRESHOLD");
        }

        if (!(nameIndex < unitIndex && unitIndex < minIndex)) {
            throw new MediStockException("Use create format: create n/NAME u/UNIT min/THRESHOLD");
        }

        String name = getArgument(text, nameIndex, unitIndex);
        String unit = getArgument(text, unitIndex, minIndex);
        String minText = getMinimum(text, minIndex);

        if (name.isEmpty() || unit.isEmpty() || minText.isEmpty()) {
            throw new MediStockException("Name, unit, and minimum threshold must not be empty.");
        }

        int min;
        try {
            min = Integer.parseInt(minText);
        } catch (NumberFormatException e) {
            throw new MediStockException("Minimum threshold must be a valid number.");
        }

        if (min <= 0) {
            throw new MediStockException("Minimum threshold must be greater than 0.");
        }

        return new CreateCommand(name, unit, min);
    }

}
