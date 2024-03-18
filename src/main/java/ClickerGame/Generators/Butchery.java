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

public class Butchery implements IGenerator, IScrappable, IMadeOutOf {

    final IInventory inventory;

    final Map<ItemId, BigInteger> itemsNecessary = Map.of(
            ItemId.Meat, new BigInteger("600"),
            ItemId.Beer, new BigInteger("10"));

    final IScrappable scrappingComponent;

    final Map<ItemId, BigInteger> itemsSpawned = Map.of(ItemId.Meat, new BigInteger("1200"));
    private final IGeneration strategy;

    public Butchery(IInventory inventory) {
        this.inventory = inventory;
        this.strategy = new PeriodicAction(90,
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
        return Map.of(ItemId.Metal, new BigInteger("750"),
                ItemId.Wood, new BigInteger("120000"),
                ItemId.Stone, new BigInteger("20000"),
                ItemId.Student, new BigInteger("60"));
    }
}
