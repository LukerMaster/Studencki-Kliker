package ClickerGame.World;

import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.function.BiConsumer;

public interface IObservableItemsProvider {
    void addListener(BiConsumer<ItemId, BigInteger> function);
}
