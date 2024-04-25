package ClickerGame.World;

import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;
import java.util.Random;

public class InventoryWithHoles implements IInventory
{
    private IInventory innerInventory;
    private Random rng;
    private float fallingOffChance = 0.02f;

    public InventoryWithHoles(IInventory inventory, Random rng)
    {
        innerInventory = inventory;
        this.rng = rng;
    }

    @Override
    public void takeItems(Map<ItemId, BigInteger> items) {
        innerInventory.takeItems(items);
    }

    @Override
    public void takeItems(ItemId id, BigInteger amount) {
        innerInventory.takeItems(id, amount);
    }

    @Override
    public void takeItems(ItemId id, int amount) {
        innerInventory.takeItems(id, amount);
    }

    @Override
    public boolean hasItems(Map<ItemId, BigInteger> items) {
        return innerInventory.hasItems(items);
    }

    @Override
    public boolean hasItems(ItemId id, BigInteger minAmount) {
        return innerInventory.hasItems(id, minAmount);
    }

    @Override
    public boolean hasItems(ItemId id, int minAmount) {
        return innerInventory.hasItems(id, minAmount);
    }

    @Override
    public void addItems(Map<ItemId, BigInteger> items) {
        if (rng.nextFloat() > fallingOffChance)
            innerInventory.addItems(items);
    }

    @Override
    public void addItems(ItemId id, BigInteger amount) {
        if (rng.nextFloat() > fallingOffChance)
            innerInventory.addItems(id, amount);
    }

    @Override
    public void addItems(ItemId id, int amount) {
        if (rng.nextFloat() > fallingOffChance)
            innerInventory.addItems(id, amount);
    }

    @Override
    public BigInteger getCount(ItemId id) {
        return innerInventory.getCount(id);
    }

    @Override
    public boolean isEmpty() {
        return innerInventory.isEmpty();
    }
}
