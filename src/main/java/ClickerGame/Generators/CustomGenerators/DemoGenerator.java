package ClickerGame.Generators.CustomGenerators;

import ClickerGame.Generators.Components.Scrapping.ScrappingForFractionOfCost;
import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.Actions.SimpleItemSpawning;
import ClickerGame.Generators.GenerationStrategies.Actions.NoAction;
import ClickerGame.Generators.GenerationStrategies.PeriodicAction;
import ClickerGame.Generators.GenerationStrategies.StartConditions.NoRequirements;
import ClickerGame.Generators.Components.Scrapping.IScrappable;
import ClickerGame.Generators.IGenerator;
import ClickerGame.Generators.IMadeOutOf;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class DemoGenerator implements IGenerator, IMadeOutOf, IScrappable
{
    private final IGeneration strategy;
    private final IScrappable scrappingComponent;

    public DemoGenerator(IInventory inventory)
    {
        strategy = new PeriodicAction(0.5f,
                new NoRequirements(),
                new NoAction(),
                new SimpleItemSpawning(Map.of(ItemId.Wood, new BigInteger("50")), inventory));
        scrappingComponent = new ScrappingForFractionOfCost(this, 3);
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
        return scrappingComponent.GetScrapValue();
    }
}
