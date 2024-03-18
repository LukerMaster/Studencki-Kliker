package ClickerGame.Generators.Factories;

import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IInventory;

public class PotatoFarm implements IGeneratorFactory {
    final private IInventory inventory;

    public PotatoFarm(IInventory inventory) {
        this.inventory = inventory;
    }
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.StandardGenerators.PotatoFarm(inventory);
    }
}
