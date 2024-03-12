package ClickerGame.Generators;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.OnFinishActions.SimpleItemSpawning;
import ClickerGame.Generators.GenerationStrategies.OnStartActions.NoAction;
import ClickerGame.Generators.GenerationStrategies.PeriodicAction;
import ClickerGame.Generators.GenerationStrategies.StartConditions.NoRequirements;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class HopsBush implements IGenerator {
    private final IGeneration strategy;

    public HopsBush(IInventory inventory) {
        strategy = new PeriodicAction(35,
                new NoRequirements(),
                new NoAction(),
                new SimpleItemSpawning(Map.of(ItemId.Hops, new BigInteger("2")), inventory));
    }

    @Override
    public IGeneration GetGenerationStrategy() {
        return strategy;
    }
}
