package ClickerGame.Generators.Factories;

import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IInventory;

public class BeerMarket implements IGeneratorFactory {
    final private IInventory inventory;

    public BeerMarket(IInventory inventory) {
        this.inventory = inventory;
    }
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.BeerMarket(inventory);
    }
}
