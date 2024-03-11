package ClickerGame.Generators;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.PeriodicSpawning;
import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public class Quarry implements IGenerator{
    private final IGeneration strategy;

    public Quarry()
    {
        strategy = new PeriodicSpawning(10,
                Map.of(ItemId.Stone, new BigInteger("32")),
                Map.of(ItemId.Beer, new BigInteger("1"),
                        ItemId.Meat, new BigInteger("8")));
    }

    @Override
    public IGeneration GetGenerationStrategy() {
        return this.strategy;
    }
}
