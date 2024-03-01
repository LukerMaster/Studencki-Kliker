package ClickerGame.Generators.GenerationStrategies;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;
import ClickerGame.World.IWorld;

import java.math.BigInteger;
import java.util.Map;

public class PeriodicSpawning implements IGeneration
{
    float currentTime = 0;
    final float secondsBetweenSpawns;
    final Map<ItemId, BigInteger> itemsSpawned;
    public PeriodicSpawning(
            float secondsBetweenSpawns,
            Map<ItemId, BigInteger> itemsSpawned)
    {
        this.secondsBetweenSpawns = secondsBetweenSpawns;
        this.itemsSpawned = itemsSpawned;
    }
    @Override
    public void Update(float deltaTime, IInventory targetInventory) {
        currentTime += deltaTime;
        while (currentTime >= secondsBetweenSpawns)
        {
            targetInventory.addItems(itemsSpawned);
            currentTime -= secondsBetweenSpawns;
        }
    }
}
