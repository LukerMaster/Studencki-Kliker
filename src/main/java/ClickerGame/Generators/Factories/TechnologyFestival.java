package ClickerGame.Generators.Factories;

import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IInventory;

import java.util.Random;

public class TechnologyFestival implements IGeneratorFactory {
    final private IInventory inventory;
    private final Random rng;

    public TechnologyFestival(IInventory inventory, Random rng) {
        this.inventory = inventory;
        this.rng = rng;
    }
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.CustomGenerators.TechnologyFestival(inventory, rng);
    }
}
