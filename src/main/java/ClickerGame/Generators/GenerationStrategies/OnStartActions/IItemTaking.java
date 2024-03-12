package ClickerGame.Generators.GenerationStrategies.OnStartActions;

import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public interface IItemTaking {
    Map<ItemId, BigInteger> GetItemsTaken();
}
