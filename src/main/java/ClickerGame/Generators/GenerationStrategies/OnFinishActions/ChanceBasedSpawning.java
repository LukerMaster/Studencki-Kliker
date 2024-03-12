package ClickerGame.Generators.GenerationStrategies.OnFinishActions;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Map;
import java.util.Random;

public class ChanceBasedSpawning implements Runnable, IChanceBased, IItemSpawning, Serializable {

    final float chance;

    final Map<ItemId, BigInteger> itemsSpawned;

    final Random rng;
    final IInventory inventory;

    public ChanceBasedSpawning(Map<ItemId, BigInteger> itemsSpawned, IInventory inventory, float chance, Random rng) {
        this.chance = chance;
        this.itemsSpawned = itemsSpawned;
        this.rng = rng;
        this.inventory = inventory;
    }

    @Override
    public void run() {
        if (rng.nextFloat() > chance)
            inventory.addItems(itemsSpawned);
    }

    @Override
    public float GetChance() {
        return chance;
    }

    @Override
    public Map<ItemId, BigInteger> GetItemsSpawned() {
        return itemsSpawned;
    }
}
