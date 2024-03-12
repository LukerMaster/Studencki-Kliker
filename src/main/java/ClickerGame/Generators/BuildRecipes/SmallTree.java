package ClickerGame.Generators.BuildRecipes;

import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class SmallTree implements IBuildRecipe {
    final IInventory targetInventory;

    public SmallTree(IInventory targetInventory) {
        this.targetInventory = targetInventory;
    }
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.SmallTree(targetInventory);
    }
    @Override
    public Map<ItemId, BigInteger> GetBuildCost() {
        return Map.of(ItemId.Wood, new BigInteger("40"),
                ItemId.Stone, new BigInteger("8"));
    }
}
