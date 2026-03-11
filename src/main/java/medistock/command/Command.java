package medistock.command;

import medistock.exception.MediStockException;
import medistock.inventory.Inventory;

public abstract class Command {
    public abstract String execute(Inventory inventory) throws MediStockException;
}
