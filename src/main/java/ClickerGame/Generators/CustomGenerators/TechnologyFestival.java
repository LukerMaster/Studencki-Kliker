package ClickerGame.Generators.CustomGenerators;

import ClickerGame.Generators.Components.Scrapping.IScrappable;
import ClickerGame.Generators.Components.Scrapping.ScrappingForFractionOfCost;
import ClickerGame.Generators.GenerationStrategies.Actions.ChanceBasedSpawning;
import ClickerGame.Generators.GenerationStrategies.Actions.SimpleItemTaking;
import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.PeriodicAction;
import ClickerGame.Generators.GenerationStrategies.StartConditions.InventoryHasItems;
import ClickerGame.Generators.IGenerator;
import ClickerGame.Generators.IMadeOutOf;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;
import java.util.Random;

public class TechnologyFestival implements IGenerator, IScrappable, IMadeOutOf {

    final IInventory inventory;

    final Map<ItemId, BigInteger> itemsNecessary = Map.of(
            ItemId.Gold, new BigInteger("50"));

    final IScrappable scrappingComponent;
    final Map<ItemId, BigInteger> itemsSpawned = Map.of(ItemId.Student, new BigInteger("1"));
    private final IGeneration strategy;
    private final Random rng;

    public TechnologyFestival(IInventory inventory, Random rng) {
        this.inventory = inventory;
        this.rng = rng;
        this.strategy = new PeriodicAction(5,
                new InventoryHasItems(itemsNecessary, inventory),
                new SimpleItemTaking(itemsNecessary, inventory),
                new ChanceBasedSpawning(itemsSpawned, inventory, 0.3f, this.rng));

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
        return Map.of(ItemId.Metal, new BigInteger("240"),
                ItemId.Wood, new BigInteger("1000"),
                ItemId.Stone, new BigInteger("200"),
                ItemId.Student, new BigInteger("10"));
    }
}
