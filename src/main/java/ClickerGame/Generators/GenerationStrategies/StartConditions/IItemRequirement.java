package ClickerGame.Generators.GenerationStrategies.StartConditions;

import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public interface IItemRequirement {
    Map<ItemId, BigInteger> GetItemsNeeded();
}
