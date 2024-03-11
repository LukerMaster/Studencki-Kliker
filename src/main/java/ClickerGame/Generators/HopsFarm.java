package ClickerGame.Generators;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.PeriodicSpawning;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class HopsFarm implements IGenerator{

    final IGeneration generation;

    public HopsFarm() {
        this.generation = new PeriodicSpawning(20,
                Map.of(ItemId.Hops, new BigInteger("6")),
                Map.of(ItemId.Beer, new BigInteger("1"),
                        ItemId.Meat, new BigInteger("1"))
                );
    }

    @Override
    public IGeneration GetGenerationStrategy() {
        return generation;
    }
}
