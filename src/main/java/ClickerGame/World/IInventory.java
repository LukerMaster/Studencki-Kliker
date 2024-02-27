package ClickerGame.World;

import ClickerGame.ItemId;

import java.math.BigInteger;

public interface IInventory {
    public void takeItems(ItemId id, BigInteger amount);
    public void takeItems(ItemId id, int amount);

    public boolean hasItems(ItemId id, BigInteger minAmount);
    public boolean hasItems(ItemId id, int minAmount);

    public void addItems(ItemId id, BigInteger amount);
    public void addItems(ItemId id, int amount);
    public BigInteger getCount(ItemId id);
}
