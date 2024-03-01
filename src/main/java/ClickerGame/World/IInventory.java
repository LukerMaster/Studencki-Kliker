package ClickerGame.World;

import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Dictionary;

public interface IInventory {
    void takeItems(Dictionary<ItemId, BigInteger> items);
    void takeItems(ItemId id, BigInteger amount);
    void takeItems(ItemId id, int amount);

    boolean hasItems(Dictionary<ItemId, BigInteger> items);
    boolean hasItems(ItemId id, BigInteger minAmount);
    boolean hasItems(ItemId id, int minAmount);

    void addItems(Dictionary<ItemId, BigInteger> items);
    void addItems(ItemId id, BigInteger amount);
    void addItems(ItemId id, int amount);
    BigInteger getCount(ItemId id);
}
