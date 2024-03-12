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

public class HuntingHut implements IGenerator{
    final IGeneration strategy;

    public HuntingHut(IInventory inventory) {
        strategy = new PeriodicAction(10,
                new InventoryHasItems(Map.of(ItemId.Beer, new BigInteger("1")), inventory),
                new SimpleItemTaking(Map.of(ItemId.Beer, new BigInteger("1")), inventory),
                new SimpleItemSpawning(Map.of(ItemId.Meat, new BigInteger("12")), inventory)
        );
    }

    @Override
    public IGeneration GetGenerationStrategy() {
        return strategy;
    }
}
