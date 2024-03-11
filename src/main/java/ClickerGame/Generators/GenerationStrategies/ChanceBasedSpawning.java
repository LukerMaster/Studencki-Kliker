package ClickerGame.Generators.GenerationStrategies;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class ChanceBasedSpawning implements IGeneration {

    float currentTime = 0;
    final float secondsBetweenSpawns;

    final float chanceOfSpawning;
    final Map<ItemId, BigInteger> itemsSpawned;
    final Map<ItemId, BigInteger> itemsTaken;
    public ChanceBasedSpawning(
            float secondsBetweenSpawns,
            float chanceOfSpawning,
            Map<ItemId, BigInteger> itemsSpawned,
            Map<ItemId, BigInteger> itemsTaken)
    {
        this.secondsBetweenSpawns = secondsBetweenSpawns;
        this.chanceOfSpawning = chanceOfSpawning;
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
                currentTime -= secondsBetweenSpawns;
            }
        }
    }
}
