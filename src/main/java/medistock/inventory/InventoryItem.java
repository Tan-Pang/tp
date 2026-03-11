package medistock.inventory;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an item in the medical inventory with a name, unit,
 * minimum threshold, total quantity, and its batches.
 */
public class InventoryItem {

    private final String name;
    private final String unit;
    private final int minimumThreshold;
    private int quantity;
    private final List<Batch> batches;

    /**
     * Creates an inventory item with the specified name, unit, and minimum threshold.
     * The item starts with zero quantity and an empty list of batches.
     *
     * @param name The name of the medical item.
     * @param unit The unit of measurement (e.g., "tablets", "ml", "mg").
     * @param minimumThreshold The minimum stock level before item is considered low stock.
     */
    public InventoryItem(String name, String unit, int minimumThreshold) {
        this.name = name;
        this.unit = unit;
        this.minimumThreshold = minimumThreshold;
        this.quantity = 0;
        this.batches = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    /**
     * Returns the minimum stock threshold of the item.
     *
     * @return The minimum threshold.
     */
    public int getMinimumThreshold() {
        return minimumThreshold;
    }

    /**
     * Returns the total quantity of this item across all batches.
     *
     * @return The total quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Stores the newly added batch and updates the total quantity.
     * The batch is added to the internal list and its quantity is added
     * to the item's total quantity.
     *
     * @param batch The batch to add to this inventory item.
     */
    public void addBatch(Batch batch) {
        batches.add(batch);
        quantity += batch.getQuantity();
    }

    /**
     * Returns whether the current quantity is below the minimum threshold.
     *
     * @return true if stock is low, false otherwise.
     */
    public boolean isLowStock() {
        return quantity < minimumThreshold;
    }
}
