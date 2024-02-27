package ClickerGame.World;

import ClickerGame.ItemId;

import java.math.BigInteger;

public interface IInventory {
    void takeItems(ItemId id, BigInteger amount);
    void takeItems(ItemId id, int amount);

    boolean hasItems(ItemId id, BigInteger minAmount);
    boolean hasItems(ItemId id, int minAmount);

    void addItems(ItemId id, BigInteger amount);
    void addItems(ItemId id, int amount);
    BigInteger getCount(ItemId id);
}
