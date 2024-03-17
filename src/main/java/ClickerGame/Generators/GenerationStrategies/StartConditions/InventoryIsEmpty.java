package ClickerGame.Generators.GenerationStrategies.StartConditions;

import ClickerGame.World.IInventory;

import java.util.function.Supplier;

public class InventoryIsEmpty implements Supplier<Boolean> {
    final IInventory inventory;

    public InventoryIsEmpty(IInventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public Boolean get() {
        return this.inventory.isEmpty();
    }
}
