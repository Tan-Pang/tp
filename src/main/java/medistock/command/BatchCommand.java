package medistock.command;

import medistock.exception.MediStockException;
import medistock.inventory.Batch;
import medistock.inventory.Inventory;
import medistock.inventory.InventoryItem;
import medistock.ui.Ui;

import java.time.LocalDate;

public class BatchCommand extends Command {
    private final String name;
    private final int quantity;
    private final LocalDate expiryDate;

    public BatchCommand(String name, int quantity, LocalDate expiryDate) {
        this.name = name;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    @Override
    public void execute(Inventory inventory, Ui ui) throws MediStockException {
        InventoryItem item = inventory.getItem(name);
        int batchNumber = item.getBatchQuantity() + 1;
        Batch newBatch = new Batch(batchNumber, quantity, expiryDate);
        item.addBatch(newBatch);
        ui.printBatch(quantity, item, expiryDate);
    }
}
