package ClickerGame.Generators.GenerationStrategies;

import ClickerGame.ItemId;
import ClickerGame.World.IWorld;

import java.math.BigInteger;

public class PeriodicSpawningOneItem implements IGeneration
{

    final IWorld world;
    float currentTime = 0;
    final float secondsBetweenSpawns;
    final ItemId spawnedId;
    final BigInteger amount;

    public PeriodicSpawningOneItem(IWorld world,
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
        currentTime += deltaTime;
        while (currentTime >= secondsBetweenSpawns)
        {
            world.GetInventory().addItems(this.spawnedId, this.amount);
            currentTime -= secondsBetweenSpawns;
        }
    }
}
