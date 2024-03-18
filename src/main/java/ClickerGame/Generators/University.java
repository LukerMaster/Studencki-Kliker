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

public class University implements IGenerator, IScrappable, IMadeOutOf {

    final IInventory inventory;

    final Map<ItemId, BigInteger> itemsNecessary = Map.of(
            ItemId.Beer, new BigInteger("1200"),
            ItemId.Vodka, new BigInteger("80"),
            ItemId.Gold, new BigInteger("4000"));

    final IScrappable scrappingComponent;
    final Map<ItemId, BigInteger> itemsSpawned = Map.of(ItemId.Student, new BigInteger("360"));
    private final IGeneration strategy;
    public University(IInventory inventory) {
        this.inventory = inventory;
        this.strategy = new PeriodicAction(240,
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
        return Map.of(ItemId.Metal, new BigInteger("6000"),
                ItemId.Wood, new BigInteger("500000"),
                ItemId.Stone, new BigInteger("100000"),
                ItemId.Student, new BigInteger("300"));
    }
}
