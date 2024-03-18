package ClickerGame.Generators.Factories;

import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IInventory;

public class Saturator implements IGeneratorFactory {
    final private IInventory inventory;

    public Saturator(IInventory inventory) {
        this.inventory = inventory;
    }
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.Saturator(inventory);
    }
}
