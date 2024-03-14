package ClickerGame.Generators.Factories;

import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IInventory;

public class Quarry implements IGeneratorFactory {

    final IInventory targetInventory;

    public Quarry(IInventory targetInventory) {
        this.targetInventory = targetInventory;
    }
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.Quarry(targetInventory);
    }


}
