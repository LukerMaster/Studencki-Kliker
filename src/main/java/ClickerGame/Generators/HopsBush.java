package ClickerGame.Generators;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.PeriodicSpawning;
import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public class HopsBush implements IGenerator {
    private final IGeneration strategy;

    public HopsBush() {
        strategy = new PeriodicSpawning(30,
                Map.of(ItemId.Hops, new BigInteger("2")),
                Map.of());
    }

    @Override
    public IGeneration GetGenerationStrategy() {
        return strategy;
    }
}
