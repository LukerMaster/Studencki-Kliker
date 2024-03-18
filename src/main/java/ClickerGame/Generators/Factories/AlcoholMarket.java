package ClickerGame.Generators.Factories;

import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IInventory;

public class AlcoholMarket implements IGeneratorFactory {
    final private IInventory inventory;

    public AlcoholMarket(IInventory inventory) {
        this.inventory = inventory;
    }
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.StandardGenerators.AlcoholMarket(inventory);
    }
}
