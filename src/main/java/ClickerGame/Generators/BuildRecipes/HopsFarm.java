package ClickerGame.Generators.BuildRecipes;

import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class HopsFarm implements IBuildRecipe {
    final IInventory targetInventory;

    public HopsFarm(IInventory targetInventory) {
        this.targetInventory = targetInventory;
    }
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.HopsFarm(targetInventory);
    }

    @Override
    public Map<ItemId, BigInteger> GetBuildCost() {
        return Map.of(
                ItemId.Hops, new BigInteger("2"),
                ItemId.Wood, new BigInteger("155"),
                ItemId.Stone, new BigInteger("10"),
                ItemId.Student, new BigInteger("1")
        );
    }
}
