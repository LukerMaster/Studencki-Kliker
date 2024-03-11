package ClickerGame.Generators;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.PeriodicSpawning;
import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public class Brewery implements IGenerator {
    private final IGeneration strategy;

    public Brewery() {
        strategy = new PeriodicSpawning(24,
                Map.of(ItemId.Beer, new BigInteger("1")),
                Map.of(ItemId.Hops, new BigInteger("3"),
                        ItemId.Meat, new BigInteger("12")));
    }

    @Override
    public IGeneration GetGenerationStrategy() {
        return this.strategy;
    }
}
