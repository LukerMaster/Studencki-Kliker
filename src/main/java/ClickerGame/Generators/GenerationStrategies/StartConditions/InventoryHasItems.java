package ClickerGame.Generators.GenerationStrategies.StartConditions;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Map;
import java.util.function.Supplier;

public class InventoryHasItems implements Supplier<Boolean>, IItemRequirement, Serializable {

    final Map<ItemId, BigInteger> itemsNecessary;

    final IInventory inventory;

    public InventoryHasItems(Map<ItemId, BigInteger> itemsNecessary, IInventory inventory) {
        this.itemsNecessary = itemsNecessary;
        this.inventory = inventory;
    }

    @Override
    public Boolean get() {
        return inventory.hasItems(itemsNecessary);
    }

    @Override
    public Map<ItemId, BigInteger> GetItemsNeeded() {
        return itemsNecessary;
    }
}
