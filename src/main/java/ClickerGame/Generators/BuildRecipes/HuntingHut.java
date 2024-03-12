package ClickerGame.Generators.BuildRecipes;

import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class HuntingHut implements IBuildRecipe{
    final IInventory targetInventory;

    public HuntingHut(IInventory targetInventory) {
        this.targetInventory = targetInventory;
    }
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.HuntingHut(targetInventory);
    }

    @Override
    public Map<ItemId, BigInteger> GetBuildCost() {
        return Map.of(
                ItemId.Wood, new BigInteger("1100"),
                ItemId.Stone, new BigInteger("220"),
                ItemId.Student, new BigInteger("3")
        );
    }
}
