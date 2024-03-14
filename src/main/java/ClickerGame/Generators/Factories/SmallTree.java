package ClickerGame.Generators.Factories;

import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IInventory;

public class SmallTree implements IGeneratorFactory {
    final IInventory targetInventory;

    public SmallTree(IInventory targetInventory) {
        this.targetInventory = targetInventory;
    }
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.SmallTree(targetInventory);
    }

}
