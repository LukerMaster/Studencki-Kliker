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
        strategy = new PeriodicSpawning(0.1f,
                Map.of(ItemId.Wood, new BigInteger("50")), Map.of());
    }
    @Override
    public IGeneration GetGenerationStrategy() {
        return strategy;
    }
}
