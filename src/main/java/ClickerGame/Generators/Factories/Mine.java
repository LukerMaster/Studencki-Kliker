package ClickerGame.Generators.Factories;

import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IInventory;

public class Mine implements IGeneratorFactory {
    final private IInventory inventory;

    public Mine(IInventory inventory) {
        this.inventory = inventory;
    }
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.Mine(inventory);
    }
}
