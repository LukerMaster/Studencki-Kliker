package ClickerGame.Generators.GenerationStrategies;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;

public class ChanceBasedSpawning implements IGeneration, IChanceBasedSpawning {

    private final Random rng;
    float currentTime = 0;
    final float secondsBetweenSpawns;

    final float chanceOfSpawning;
    final Map<ItemId, BigInteger> itemsSpawned;
    final Map<ItemId, BigInteger> itemsTaken;
    private List<Consumer<Float>> onProgressListeners = new ArrayList<>();

    public ChanceBasedSpawning(
            float secondsBetweenSpawns,
            float chanceOfSpawning,
            Map<ItemId, BigInteger> itemsSpawned,
            Map<ItemId, BigInteger> itemsTaken,
            Random rng)
    {
        this.secondsBetweenSpawns = secondsBetweenSpawns;
        this.chanceOfSpawning = chanceOfSpawning;
        this.itemsSpawned = itemsSpawned;
        this.itemsTaken = itemsTaken;
        this.rng = rng;
    }
    @Override
    public void Update(float deltaTime, IInventory targetInventory) {
        currentTime += deltaTime;
        NotifyListeners();
        while (currentTime >= secondsBetweenSpawns)
        {
            if (rng.nextFloat() > chanceOfSpawning)
            {
                if (targetInventory.hasItems(itemsTaken))
                {
                    targetInventory.takeItems(itemsTaken);
                    targetInventory.addItems(itemsSpawned);
                }
            }
            currentTime -= secondsBetweenSpawns;
        }
    }

    private void NotifyListeners()
    {
        for (Consumer<Float> onProgressListener : onProgressListeners) {
            onProgressListener.accept(GetProgressToNextSpawn());
        }
    }
    @Override
    public void AddOnProgressChangeListener(Consumer<Float> function) {
        if (onProgressListeners == null)
            onProgressListeners = new ArrayList<>();

        onProgressListeners.add(function);
    }

    @Override
    public float GetProgressToNextSpawn() {
        return currentTime / secondsBetweenSpawns;
    }

    @Override
    public float GetSecondsBetweenSpawns() {
        return secondsBetweenSpawns;
    }

    @Override
    public Map<ItemId, BigInteger> GetItemsSpawned() {
        return itemsSpawned;
    }

    @Override
    public Map<ItemId, BigInteger> GetItemsTaken() {
        return itemsTaken;
    }

    @Override
    public float GetChanceOfSpawning() {
        return chanceOfSpawning;
    }
}
