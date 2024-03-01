package ClickerGame.World;

import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public interface IInventory {
    void takeItems(Map<ItemId, BigInteger> items);
    void takeItems(ItemId id, BigInteger amount);
    void takeItems(ItemId id, int amount);

    boolean hasItems(Map<ItemId, BigInteger> items);
    boolean hasItems(ItemId id, BigInteger minAmount);
    boolean hasItems(ItemId id, int minAmount);

    void addItems(Map<ItemId, BigInteger> items);
    void addItems(ItemId id, BigInteger amount);
    void addItems(ItemId id, int amount);
    BigInteger getCount(ItemId id);
}
