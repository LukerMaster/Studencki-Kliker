package ClickerGame.Generators.GenerationStrategies;

import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public interface IChanceBasedSpawning {
    float GetSecondsBetweenSpawns();
    Map<ItemId, BigInteger> GetItemsSpawned();
    Map<ItemId, BigInteger> GetItemsTaken();
    float GetChanceOfSpawning();
}
