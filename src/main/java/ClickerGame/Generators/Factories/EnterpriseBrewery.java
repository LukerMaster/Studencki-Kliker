package ClickerGame.Generators.Factories;

import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IInventory;

public class EnterpriseBrewery implements IGeneratorFactory {
    final private IInventory inventory;

    public EnterpriseBrewery(IInventory inventory) {
        this.inventory = inventory;
    }
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.EnterpriseBrewery(inventory);
    }
}
