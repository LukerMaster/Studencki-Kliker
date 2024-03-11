package ClickerGame.Generators;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.PeriodicSpawning;
import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public class HuntingHut implements IGenerator{
    final IGeneration strategy;

    public HuntingHut() {
        this.strategy = new PeriodicSpawning(20,
                Map.of(ItemId.Meat, new BigInteger("5")),
                Map.of(ItemId.Beer, new BigInteger("1")));
    }

    @Override
    public IGeneration GetGenerationStrategy() {
        return strategy;
    }
}
