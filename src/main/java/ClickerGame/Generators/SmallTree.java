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

public class SmallTree implements IGenerator, IMadeOutOf {

    private final IGeneration strategy;

    public SmallTree(IInventory inventory)
    {
        strategy = new PeriodicAction(15,
                new NoRequirements(),
                new NoAction(),
                new SimpleItemSpawning(
                        Map.of(ItemId.Wood, new BigInteger("10")),
                        inventory
                ));
    }
    @Override
    public IGeneration GetGenerationStrategy() {
        return strategy;
    }

    @Override
    public Map<ItemId, BigInteger> GetWhatItsMadeOutOf() {
        return Map.of(ItemId.Wood, new BigInteger("40"),
                ItemId.Stone, new BigInteger("8"));
    }
}