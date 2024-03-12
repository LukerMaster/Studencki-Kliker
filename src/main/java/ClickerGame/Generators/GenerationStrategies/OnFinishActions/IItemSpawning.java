package ClickerGame.Generators.GenerationStrategies.OnFinishActions;

import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public interface IItemSpawning {
    Map<ItemId, BigInteger> GetItemsSpawned();
}
