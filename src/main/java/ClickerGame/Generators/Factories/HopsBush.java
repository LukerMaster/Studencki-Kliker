package ClickerGame.Generators.Factories;

import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IInventory;

public class HopsBush implements IGeneratorFactory {

    final IInventory targetInventory;

    public HopsBush(IInventory targetInventory) {
        this.targetInventory = targetInventory;
    }
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.CustomGenerators.HopsBush(targetInventory);
    }
}
