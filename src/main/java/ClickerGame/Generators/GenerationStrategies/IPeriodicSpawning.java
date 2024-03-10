package ClickerGame.Generators.GenerationStrategies;

import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public interface IPeriodicSpawning {
    float GetSecondsBetweenSpawns();
    Map<ItemId, BigInteger> GetItemsSpawned();
    Map<ItemId, BigInteger> GetItemsTaken();
}
