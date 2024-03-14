package ClickerGame.Generators.GenerationStrategies.Actions;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Map;

public class SimpleItemSpawning implements Runnable, IItemSpawning, Serializable {
    private final Map<ItemId, BigInteger> itemsSpawned;

    final IInventory inventory;

    public SimpleItemSpawning(Map<ItemId, BigInteger> itemsSpawned, IInventory inventory) {
        this.itemsSpawned = itemsSpawned;
        this.inventory = inventory;
    }

    @Override
    public void run() {
        inventory.addItems(itemsSpawned);
    }

    @Override
    public Map<ItemId, BigInteger> GetItemsSpawned() {
        return itemsSpawned;
    }
}
