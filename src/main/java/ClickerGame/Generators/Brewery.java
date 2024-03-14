package ClickerGame.Generators;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.Actions.SimpleItemSpawning;
import ClickerGame.Generators.GenerationStrategies.Actions.SimpleItemTaking;
import ClickerGame.Generators.GenerationStrategies.PeriodicAction;
import ClickerGame.Generators.GenerationStrategies.StartConditions.InventoryHasItems;
import ClickerGame.Generators.Scraping.IScrappable;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class Brewery implements IGenerator, IMadeOutOf, IScrappable {
    private final IGeneration strategy;

    public Brewery(IInventory inventory) {

        strategy = new PeriodicAction(10,
                new InventoryHasItems(Map.of(ItemId.Hops, new BigInteger("25"), ItemId.Meat, new BigInteger("12")), inventory),
                new SimpleItemTaking(Map.of(ItemId.Hops, new BigInteger("25"), ItemId.Meat, new BigInteger("12")), inventory),
                new SimpleItemSpawning(Map.of(ItemId.Beer, new BigInteger("10")), inventory)
        );
    }

    @Override
    public IGeneration GetGenerationStrategy() {
        return this.strategy;
    }

    @Override
    public Map<ItemId, BigInteger> GetWhatItsMadeOutOf() {
        return Map.of(
                ItemId.Wood, new BigInteger("750"),
                ItemId.Stone, new BigInteger("450"),
                ItemId.Student, new BigInteger("3")
        );
    }

    @Override
    public Map<ItemId, BigInteger> GetScrapValue() {
        return Map.of(
                ItemId.Wood, new BigInteger("350"),
                ItemId.Stone, new BigInteger("250"),
                ItemId.Student, new BigInteger("3")
        );
    }
}
