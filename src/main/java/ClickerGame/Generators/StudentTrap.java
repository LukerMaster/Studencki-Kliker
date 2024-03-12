package ClickerGame.Generators;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.OnFinishActions.ChanceBasedSpawning;
import ClickerGame.Generators.GenerationStrategies.OnStartActions.SimpleItemTaking;
import ClickerGame.Generators.GenerationStrategies.PeriodicAction;
import ClickerGame.Generators.GenerationStrategies.StartConditions.InventoryHasItems;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;
import java.util.Random;

public class StudentTrap implements IGenerator {


    final IGeneration strategy;
    public StudentTrap(Random rng, IInventory inventory) {

        strategy = new PeriodicAction(15,
                new InventoryHasItems(Map.of(ItemId.Beer, new BigInteger("1")), inventory),
                new SimpleItemTaking(Map.of(ItemId.Beer, new BigInteger("1")), inventory),
                new ChanceBasedSpawning(Map.of(ItemId.Student, new BigInteger("1")), inventory, 0.2f, rng)
                );
    }
    @Override
    public IGeneration GetGenerationStrategy() {
        return strategy;
    }
}
