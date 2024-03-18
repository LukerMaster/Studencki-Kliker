package ClickerGame.Generators.CustomGenerators;

import ClickerGame.Generators.Components.Scrapping.ScrappingForFractionOfCost;
import ClickerGame.Generators.GenerationStrategies.Actions.SimpleItemSpawning;
import ClickerGame.Generators.GenerationStrategies.IGeneration;
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

public class SmallTreeFarm implements IGenerator, IMadeOutOf, IScrappable {

    private final IGeneration strategy;
    private final IScrappable scrappingComponent;

    public SmallTreeFarm(IInventory inventory)
    {
        strategy = new PeriodicAction(15,
                new NoRequirements(),
                new NoAction(),
                new SimpleItemSpawning(Map.of(ItemId.Wood, new BigInteger("20")), inventory));
        scrappingComponent = new ScrappingForFractionOfCost(this, 3);
    }
    @Override
    public IGeneration GetGenerationStrategy() {
        return strategy;
    }

    @Override
    public Map<ItemId, BigInteger> GetWhatItsMadeOutOf() {
        return Map.of(ItemId.Wood, new BigInteger("40"),
                ItemId.Stone, new BigInteger("10"));
    }

    @Override
    public Map<ItemId, BigInteger> GetScrapValue() {
        return scrappingComponent.GetScrapValue();
    }
}