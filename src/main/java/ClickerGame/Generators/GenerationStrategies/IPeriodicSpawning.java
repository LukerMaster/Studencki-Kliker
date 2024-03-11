package ClickerGame.Generators.GenerationStrategies;

import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;
import java.util.function.Consumer;

public interface IPeriodicSpawning {

    void AddOnProgressChangeListener(Consumer<Float> function);
    float GetProgressToNextSpawn();
    float GetSecondsBetweenSpawns();
    Map<ItemId, BigInteger> GetItemsSpawned();
    Map<ItemId, BigInteger> GetItemsTaken();
}
