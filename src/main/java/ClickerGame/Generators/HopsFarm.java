package ClickerGame.Generators;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.Actions.SimpleItemSpawning;
import ClickerGame.Generators.GenerationStrategies.Actions.SimpleItemTaking;
import ClickerGame.Generators.GenerationStrategies.PeriodicAction;
import ClickerGame.Generators.GenerationStrategies.StartConditions.InventoryHasItems;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class HopsFarm implements IGenerator, IMadeOutOf {

    final IGeneration strategy;

    public HopsFarm(IInventory inventory) {
        strategy = new PeriodicAction(10,
                new InventoryHasItems(Map.of(ItemId.Beer, new BigInteger("1"), ItemId.Meat, new BigInteger("1")), inventory),
                new SimpleItemTaking(Map.of(ItemId.Beer, new BigInteger("1"), ItemId.Meat, new BigInteger("1")), inventory),
                new SimpleItemSpawning(Map.of(ItemId.Hops, new BigInteger("9")), inventory)
        );
    }

    @Override
    public IGeneration GetGenerationStrategy() {
        return strategy;
    }

    @Override
    public Map<ItemId, BigInteger> GetWhatItsMadeOutOf() {
        return Map.of(
                ItemId.Hops, new BigInteger("2"),
                ItemId.Wood, new BigInteger("155"),
                ItemId.Stone, new BigInteger("10"),
                ItemId.Student, new BigInteger("1")
        );
    }
}
