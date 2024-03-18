package ClickerGame.Generators.Factories;

import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IInventory;

public class University implements IGeneratorFactory {
    final private IInventory inventory;

    public University(IInventory inventory) {
        this.inventory = inventory;
    }
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.University(inventory);
    }
}
