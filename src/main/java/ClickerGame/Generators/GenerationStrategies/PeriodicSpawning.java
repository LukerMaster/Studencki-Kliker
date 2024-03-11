package ClickerGame.Generators.GenerationStrategies;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class PeriodicSpawning implements IGeneration, IPeriodicSpawning
{
    float currentTime = 0;
    final float secondsBetweenSpawns;
    final Map<ItemId, BigInteger> itemsSpawned;
    final Map<ItemId, BigInteger> itemsTaken;
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
