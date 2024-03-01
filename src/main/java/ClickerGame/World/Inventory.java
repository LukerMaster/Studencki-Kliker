package ClickerGame.World;

import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Dictionary;
import java.util.Hashtable;

public class Inventory implements IInventory {
    final Dictionary<ItemId, BigInteger> items = new Hashtable<>();

    @Override
    public void takeItems(Dictionary<ItemId, BigInteger> items) {
        for (ItemId key : ItemId.values())
        {
            if (items.get(key) != null)
                takeItems(key, items.get(key));
        }
    }

    @Override
    public void takeItems(ItemId id, BigInteger amount) {
        if (items.get(id) != null)
        {
            if (items.get(id).compareTo(amount) > 0)
            {
                items.put(id, items.get(id).subtract(amount));
            }
        }
        throw new RuntimeException("Not enough items.");
    }

    @Override
    public void takeItems(ItemId id, int amount) {
        takeItems(id, new BigInteger(String.valueOf(amount)));
    }

    @Override
    public boolean hasItems(Dictionary<ItemId, BigInteger> items) {
        for (ItemId key : ItemId.values())
        {
            if (items.get(key) != null && !hasItems(key, items.get(key)))
                return false;
        }
        return true;
    }

    @Override
    public boolean hasItems(ItemId id, BigInteger minAmount) {
        if (items.get(id) == null)
            return false;
        return items.get(id).compareTo(minAmount) > 0;
    }

    @Override
    public boolean hasItems(ItemId id, int minAmount) {
        return hasItems(id, new BigInteger(String.valueOf(minAmount)));
    }

    @Override
    public void addItems(Dictionary<ItemId, BigInteger> items) {
        for (ItemId key : ItemId.values())
        {
            if (items.get(key) != null)
                addItems(key, items.get(key));
        }
    }

    @Override
    public void addItems(ItemId id, BigInteger amount) {
        if (items.get(id) == null)
            items.put(id, amount);
        else
            items.put(id, items.get(id).add(amount));
    }

    @Override
    public void addItems(ItemId id, int amount) {
        addItems(id, new BigInteger(String.valueOf(amount)));
    }

    @Override
    public BigInteger getCount(ItemId id) {
        if (items.get(id) == null)
            return new BigInteger("0");
        return items.get(id);
    }

}