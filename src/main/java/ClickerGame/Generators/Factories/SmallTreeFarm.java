package ClickerGame.Generators.Factories;

import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IInventory;

public class SmallTreeFarm implements IGeneratorFactory {
    final IInventory targetInventory;

    public SmallTreeFarm(IInventory targetInventory) {
        this.targetInventory = targetInventory;
    }
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.SmallTreeFarm(targetInventory);
    }

}
