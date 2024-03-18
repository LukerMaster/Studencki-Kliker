package ClickerGame.Generators.Factories;

import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IInventory;

public class HuntingHut implements IGeneratorFactory {
    final IInventory targetInventory;

    public HuntingHut(IInventory targetInventory) {
        this.targetInventory = targetInventory;
    }
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.StandardGenerators.HuntingHut(targetInventory);
    }


}
