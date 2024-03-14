package ClickerGame.Generators.GenerationStrategies.Actions;

import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public interface IItemTaking {
    Map<ItemId, BigInteger> GetItemsTaken();
}
