package ClickerGame.Generators.Factories;

import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IInventory;

public class HopsFarm implements IGeneratorFactory {
    final IInventory targetInventory;

    public HopsFarm(IInventory targetInventory) {
        this.targetInventory = targetInventory;
    }
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.StandardGenerators.HopsFarm(targetInventory);
    }
}
