package ClickerGame.Generators;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.OnFinishActions.SimpleItemSpawning;
import ClickerGame.Generators.GenerationStrategies.OnStartActions.SimpleItemTaking;
import ClickerGame.Generators.GenerationStrategies.PeriodicAction;
import ClickerGame.Generators.GenerationStrategies.StartConditions.InventoryHasItems;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class Quarry implements IGenerator{
    private final IGeneration strategy;

    public Quarry(IInventory inventory)
    {
        strategy = new PeriodicAction(10,
                new InventoryHasItems(Map.of(ItemId.Beer, new BigInteger("1"), ItemId.Meat, new BigInteger("8")), inventory),
                new SimpleItemTaking(Map.of(ItemId.Beer, new BigInteger("1"), ItemId.Meat, new BigInteger("8")), inventory),
                new SimpleItemSpawning(Map.of(ItemId.Stone, new BigInteger("32")), inventory)
        );
    }

    @Override
    public IGeneration GetGenerationStrategy() {
        return this.strategy;
    }
}
