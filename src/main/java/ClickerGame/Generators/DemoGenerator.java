package ClickerGame.Generators;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.PeriodicSpawning;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class DemoGenerator implements IGenerator
{
    private final IGeneration strategy;

    public DemoGenerator()
    {
        strategy = new PeriodicSpawning(0.5f,
                Map.of(ItemId.Gold, new BigInteger("750")), Map.of());
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
