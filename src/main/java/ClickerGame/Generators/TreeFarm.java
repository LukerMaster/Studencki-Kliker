package ClickerGame.Core.Generators;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.PeriodicSpawning;
import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class TreeFarm implements IGenerator {

    private final IGeneration strategy;

    public TreeFarm()
    {
        strategy = new PeriodicSpawning(10,
                Map.of(ItemId.Wood, new BigInteger("10")), Map.of());
    }
    @Override
    public void Update(float deltaTime, IInventory targetInventory) {
        strategy.Update(deltaTime, targetInventory);
    }

    @Override
    public IGeneration GetGenerationStrategy() {
        return strategy;
    }
}