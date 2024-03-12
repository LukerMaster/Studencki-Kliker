package ClickerGame.Generators;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.OnFinishActions.SimpleItemSpawning;
import ClickerGame.Generators.GenerationStrategies.OnStartActions.NoAction;
import ClickerGame.Generators.GenerationStrategies.OnStartActions.SimpleItemTaking;
import ClickerGame.Generators.GenerationStrategies.PeriodicAction;
import ClickerGame.Generators.GenerationStrategies.StartConditions.InventoryHasItems;
import ClickerGame.Generators.GenerationStrategies.StartConditions.NoRequirements;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class Brewery implements IGenerator {
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
}
