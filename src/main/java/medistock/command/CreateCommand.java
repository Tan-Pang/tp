package medistock.command;

import medistock.exception.MediStockException;
import medistock.inventory.Inventory;
import medistock.inventory.InventoryItem;

public class CreateCommand extends Command {
    private final String name;
    private final String unit;
    private final int minimumThreshold;

    public CreateCommand(String name, String unit, int minimumThreshold) {
        this.name = name;
        this.unit = unit;
        this.minimumThreshold = minimumThreshold;
    }

    @Override
    public String execute(Inventory inventory) throws MediStockException {
        InventoryItem item = new InventoryItem(name, unit, minimumThreshold);
        inventory.addItem(item);
        return "Product created:\n" + name + " (" + unit + ")\n" + "Minimum threshold: " + minimumThreshold;
    }
}
