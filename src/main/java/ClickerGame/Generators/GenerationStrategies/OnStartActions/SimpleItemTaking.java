package ClickerGame.Generators.GenerationStrategies.OnStartActions;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Map;

public class SimpleItemTaking implements Runnable, IItemTaking, Serializable {

    final Map<ItemId, BigInteger> itemsTaken;

    final IInventory targetInventory;

    public SimpleItemTaking(Map<ItemId, BigInteger> itemsTaken, IInventory targetInventory) {
        this.itemsTaken = itemsTaken;
        this.targetInventory = targetInventory;
    }

    @Override
    public void run() {
        this.targetInventory.takeItems(itemsTaken);
    }

    @Override
    public Map<ItemId, BigInteger> GetItemsTaken() {
        return itemsTaken;
    }
}
