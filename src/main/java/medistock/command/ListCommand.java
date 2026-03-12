package medistock.command;

import medistock.exception.MediStockException;
import medistock.inventory.Inventory;
import medistock.ui.Ui;

/**
 * Command to list all items in the inventory.
 */
public class ListCommand extends Command {

    /**
     * Executes the list command by displaying all inventory items.
     *
     * @param inventory The inventory to display.
     * @param ui The UI for displaying the inventory.
     * @throws MediStockException If an error occurs during execution.
     */
    @Override
    public void execute(Inventory inventory, Ui ui) throws MediStockException {
        ui.showInventoryList(inventory);
    }
}
