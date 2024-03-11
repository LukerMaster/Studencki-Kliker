package ClickerGame.Generators.GenerationStrategies;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class PeriodicSpawning implements IGeneration, IPeriodicSpawning
{
    float currentTime = 0;
    final float secondsBetweenSpawns;
    final Map<ItemId, BigInteger> itemsSpawned;
    final Map<ItemId, BigInteger> itemsTaken;

    transient List<Consumer<Float>> onProgressListeners = new ArrayList<>();

    public PeriodicSpawning(
            float secondsBetweenSpawns,
            Map<ItemId, BigInteger> itemsSpawned, Map<ItemId, BigInteger> itemsTaken)
    {
        this.secondsBetweenSpawns = secondsBetweenSpawns;
        this.itemsSpawned = itemsSpawned;
        this.itemsTaken = itemsTaken;
    }
    @Override
    public void Update(float deltaTime, IInventory targetInventory) {
        currentTime += deltaTime;
        NotifyListeners();
        while (currentTime >= secondsBetweenSpawns)
        {
            if (targetInventory.hasItems(itemsTaken))
            {
                targetInventory.takeItems(itemsTaken);
                targetInventory.addItems(itemsSpawned);
            }
            currentTime -= secondsBetweenSpawns;
        }
    }

    private void NotifyListeners()
    {
        if (onProgressListeners == null)
            onProgressListeners = new ArrayList<>();
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
}
