package ClickerGame.Generators;

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

public class EnterpriseBrewery implements IGenerator, IScrappable, IMadeOutOf  {
    final IInventory inventory;

    final Map<ItemId, BigInteger> itemsNecessary = Map.of(
            ItemId.Gold, new BigInteger("2000"),
            ItemId.Hops, new BigInteger("2000"));

    final IScrappable scrappingComponent;
    final Map<ItemId, BigInteger> itemsSpawned = Map.of(ItemId.Beer, new BigInteger("1000"));
    private final IGeneration strategy;
    public EnterpriseBrewery(IInventory inventory) {
        this.inventory = inventory;
        this.strategy = new PeriodicAction(8,
                new InventoryHasItems(itemsNecessary, inventory),
                new SimpleItemTaking(itemsNecessary, inventory),
                new SimpleItemSpawning(itemsSpawned, inventory));
        scrappingComponent = new ScrappingForFractionOfCost(this, 3);
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
        return Map.of(ItemId.Metal, new BigInteger("10000"),
                ItemId.Wood, new BigInteger("850000"),
                ItemId.Stone, new BigInteger("250000"),
                ItemId.Student, new BigInteger("300"));
    }
}
