package ClickerGame.Generators.BuildRecipes;

import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class DemoGenerator implements IBuildRecipe {
    final IInventory targetInventory;

    public DemoGenerator(IInventory targetInventory) {
        this.targetInventory = targetInventory;
    }
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.DemoGenerator(targetInventory);
    }

    @Override
    public Map<ItemId, BigInteger> GetBuildCost() {
        return Map.of(ItemId.Wood, new BigInteger("1"));
    }
}
