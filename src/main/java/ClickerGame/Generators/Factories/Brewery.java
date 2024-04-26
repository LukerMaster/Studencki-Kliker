package ClickerGame.Generators.Factories;

import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IInventory;

public class Brewery implements IGeneratorFactory {

    final IInventory targetInventory;

    public Brewery(IInventory targetInventory) {
        this.targetInventory = targetInventory;
    }

    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.StandardGenerators.Brewery(targetInventory);
    }
}
