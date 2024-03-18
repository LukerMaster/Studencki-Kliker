package ClickerGame.Generators.CustomGenerators;

import ClickerGame.Generators.Components.Scrapping.IScrappable;
import ClickerGame.Generators.Components.Scrapping.ScrappingForFractionOfCost;
import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.Actions.SimpleItemSpawning;
import ClickerGame.Generators.GenerationStrategies.Actions.NoAction;
import ClickerGame.Generators.GenerationStrategies.PeriodicAction;
import ClickerGame.Generators.GenerationStrategies.StartConditions.NoRequirements;
import ClickerGame.Generators.IGenerator;
import ClickerGame.Generators.IMadeOutOf;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class HopsBush implements IGenerator, IMadeOutOf, IScrappable {
    private final IGeneration strategy;
    private final IScrappable scrappingComponent;

    public HopsBush(IInventory inventory) {
        strategy = new PeriodicAction(35,
                new NoRequirements(),
                new NoAction(),
                new SimpleItemSpawning(Map.of(ItemId.Hops, new BigInteger("2")), inventory));
        scrappingComponent = new ScrappingForFractionOfCost(this, 3);
    }

    @Override
    public IGeneration GetGenerationStrategy() {
        return strategy;
    }

    @Override
    public Map<ItemId, BigInteger> GetWhatItsMadeOutOf() {
        return Map.of(ItemId.Hops, new BigInteger("2"),
                ItemId.Wood, new BigInteger("125"));
    }

    @Override
    public Map<ItemId, BigInteger> GetScrapValue() {
        return scrappingComponent.GetScrapValue();
    }
}
