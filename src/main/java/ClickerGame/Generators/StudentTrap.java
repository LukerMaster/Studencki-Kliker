package ClickerGame.Generators;

import ClickerGame.Generators.Components.Scrapping.IScrappable;
import ClickerGame.Generators.Components.Scrapping.ScrappingForFractionOfCost;
import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.Actions.ChanceBasedSpawning;
import ClickerGame.Generators.GenerationStrategies.Actions.SimpleItemTaking;
import ClickerGame.Generators.GenerationStrategies.PeriodicAction;
import ClickerGame.Generators.GenerationStrategies.StartConditions.InventoryHasItems;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;
import java.util.Random;

public class StudentTrap implements IGenerator, IMadeOutOf, IScrappable {


    final IGeneration strategy;
    private final IScrappable scrappingComponent;

    public StudentTrap(Random rng, IInventory inventory) {

        strategy = new PeriodicAction(15,
                new InventoryHasItems(Map.of(ItemId.Beer, new BigInteger("1")), inventory),
                new SimpleItemTaking(Map.of(ItemId.Beer, new BigInteger("1")), inventory),
                new ChanceBasedSpawning(Map.of(ItemId.Student, new BigInteger("1")), inventory, 0.2f, rng)
                );
        scrappingComponent = new ScrappingForFractionOfCost(this, 3);
    }
    @Override
    public IGeneration GetGenerationStrategy() {
        return strategy;
    }

    @Override
    public Map<ItemId, BigInteger> GetWhatItsMadeOutOf() {
        return Map.of(
                ItemId.Wood, new BigInteger("5"),
                ItemId.Beer, new BigInteger("1")
        );
    }

    @Override
    public Map<ItemId, BigInteger> GetScrapValue() {
        return scrappingComponent.GetScrapValue();
    }
}
