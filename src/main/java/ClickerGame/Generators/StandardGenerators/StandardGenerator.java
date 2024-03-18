package ClickerGame.Generators.StandardGenerators;

import ClickerGame.Generators.Components.Scrapping.IScrappable;
import ClickerGame.Generators.Components.Scrapping.ScrappingForFractionOfCost;
import ClickerGame.Generators.GenerationStrategies.Actions.SimpleItemSpawning;
import ClickerGame.Generators.GenerationStrategies.Actions.SimpleItemTaking;
import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.PeriodicAction;
import ClickerGame.Generators.GenerationStrategies.StartConditions.InventoryHasItems;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class StandardGenerator implements IStandardGenerator {
    final IScrappable scrappingComponent;
    private final IGeneration strategy;
    private final Map<ItemId, BigInteger> madeOutOf;
    public StandardGenerator(IInventory inventory,
                             Map<ItemId, BigInteger> madeOutOf,
                             float secondsBetweenSpawns,
                             Map<ItemId, BigInteger> itemsNecessary,
                             Map<ItemId, BigInteger> itemsSpawned,
                             int scrappingDivisor) {
        this.madeOutOf = madeOutOf;
        this.strategy = new PeriodicAction(secondsBetweenSpawns,
                new InventoryHasItems(itemsNecessary, inventory),
                new SimpleItemTaking(itemsNecessary, inventory),
                new SimpleItemSpawning(itemsSpawned, inventory));
        scrappingComponent = new ScrappingForFractionOfCost(this, scrappingDivisor);
    }

    @Override
    public Map<ItemId, BigInteger> GetScrapValue() {
        return scrappingComponent.GetScrapValue();
    }

    @Override
    public IGeneration GetGenerationStrategy() {
        return strategy;
    }

    @Override
    public Map<ItemId, BigInteger> GetWhatItsMadeOutOf() {
        return madeOutOf;
    }
}
