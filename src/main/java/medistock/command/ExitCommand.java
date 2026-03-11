package medistock.command;

import medistock.exception.MediStockException;
import medistock.inventory.Inventory;
import medistock.ui.Ui;

public class ExitCommand extends Command{
    public ExitCommand() {
        this.isExit = true;
    }

    public void execute(Inventory inventory, Ui ui) throws MediStockException {
        ui.printExit();
        this.isExit = true;
    }
}
