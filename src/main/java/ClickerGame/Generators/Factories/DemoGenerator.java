package ClickerGame.Generators.Factories;

import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IInventory;

public class DemoGenerator implements IGeneratorFactory {
    final IInventory targetInventory;

    public DemoGenerator(IInventory targetInventory) {
        this.targetInventory = targetInventory;
    }
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.DemoGenerator(targetInventory);
    }


}
