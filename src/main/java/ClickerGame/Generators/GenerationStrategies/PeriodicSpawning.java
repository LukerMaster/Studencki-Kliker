package ClickerGame.Generators.GenerationStrategies;

import ClickerGame.ItemId;
import ClickerGame.World.IWorld;

import java.math.BigInteger;

public class PeriodicSpawning implements IGenerationStrategy
{

    IWorld world;
    float currentTime = 0;
    float secondsBetweenSpawns;
    ItemId spawnedId;
    BigInteger amount;

    public PeriodicSpawning(IWorld world,
                            float secondsBetweenSpawns,
                            ItemId spawnedId,
                            BigInteger amount)
    {
        this.world = world;
        this.secondsBetweenSpawns = secondsBetweenSpawns;
        this.spawnedId = spawnedId;
        this.amount = amount;
    }


    @Override
    public void Update(float deltaTime) {
        if (currentTime >= secondsBetweenSpawns)
        {
            world.GetInventory().addItems(this.spawnedId, this.amount);
        }
    }
}
