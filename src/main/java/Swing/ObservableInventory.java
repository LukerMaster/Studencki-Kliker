package Swing;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;
import ClickerGame.World.IObservableItemsProvider;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.function.BiConsumer;


/**
 * Since we need to update the texts everytime the amount changes, we need a class
 * that has inventory observable. Decorating the initial inventory provided by the game
 * is the way to go.
 */
public class ObservableInventory implements IInventory, IObservableItemsProvider {

    final IInventory inventory;

    /*
     * This is a good time to appreciate the beauty of C#'s Function and Action classes.
     * One more argument and I'd have to create redundant wrappers for simple arguments...
     * (Well - Not to mention there is dedicated event system for Observer pattern)
     * Why is Java like this?
     */
    final List<BiConsumer<ItemId,BigInteger>> listeners = new ArrayList<>();

    @Override
    public void addListener(BiConsumer<ItemId,BigInteger> function) {
        listeners.add(function);
    }

    private void notifyAboutChange(ItemId id, BigInteger newAmount)
    {
        for (BiConsumer<ItemId, BigInteger> listener : listeners)
            listener.accept(id, newAmount);
    }


    public ObservableInventory(IInventory innerInventory)
    {
        inventory = innerInventory;
    }

    @Override
    public void takeItems(Dictionary<ItemId, BigInteger> items) {
        inventory.takeItems(items);
        for (ItemId id: ItemId.values()) {
            notifyAboutChange(id, inventory.getCount(id));
        }
    }

    @Override
    public void takeItems(ItemId id, BigInteger amount) {
        inventory.takeItems(id, amount);
        notifyAboutChange(id, inventory.getCount(id));
    }

    @Override
    public void takeItems(ItemId id, int amount) {
        inventory.takeItems(id, amount);
        notifyAboutChange(id, inventory.getCount(id));
    }

    @Override
    public boolean hasItems(Dictionary<ItemId, BigInteger> items) {
        return inventory.hasItems(items);
    }

    @Override
    public boolean hasItems(ItemId id, BigInteger minAmount) {
        return inventory.hasItems(id, minAmount);
    }

    @Override
    public boolean hasItems(ItemId id, int minAmount) {
        return inventory.hasItems(id, minAmount);
    }

    @Override
    public void addItems(Dictionary<ItemId, BigInteger> items) {
        inventory.addItems(items);
        for (ItemId id: ItemId.values()) {
            notifyAboutChange(id, inventory.getCount(id));
        }
    }

    @Override
    public void addItems(ItemId id, BigInteger amount) {
        inventory.addItems(id, amount);
        notifyAboutChange(id, inventory.getCount(id));
    }

    @Override
    public void addItems(ItemId id, int amount) {
        inventory.addItems(id, amount);
        notifyAboutChange(id, inventory.getCount(id));
    }

    @Override
    public BigInteger getCount(ItemId id) {
        return inventory.getCount(id);
    }
}
