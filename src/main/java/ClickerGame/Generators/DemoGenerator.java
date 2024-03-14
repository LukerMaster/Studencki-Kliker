package ClickerGame.Generators;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.OnFinishActions.SimpleItemSpawning;
import ClickerGame.Generators.GenerationStrategies.OnStartActions.NoAction;
import ClickerGame.Generators.GenerationStrategies.PeriodicAction;
import ClickerGame.Generators.GenerationStrategies.StartConditions.NoRequirements;
import ClickerGame.Generators.Scraping.IScrappable;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class DemoGenerator implements IGenerator, IMadeOutOf, IScrappable
{
    private final IGeneration strategy;

    public DemoGenerator(IInventory inventory)
    {
        strategy = new PeriodicAction(0.5f,
                new NoRequirements(),
                new NoAction(),
                new SimpleItemSpawning(Map.of(ItemId.Wood, new BigInteger("50")), inventory));
    }
    @Override
    public IGeneration GetGenerationStrategy() {
        return strategy;
    }

    @Override
    public Map<ItemId, BigInteger> GetWhatItsMadeOutOf() {
        return Map.of(ItemId.Wood, new BigInteger("1"));
    }

    @Override
    public Map<ItemId, BigInteger> GetScrapValue() {
        return Map.of(
                ItemId.Wood, new BigInteger("750")
        );
    }
}
