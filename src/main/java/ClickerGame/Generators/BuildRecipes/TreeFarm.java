package ClickerGame.Generators.BuildRecipes;

import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public class TreeFarm implements IBuildRecipe {
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Core.Generators.TreeFarm();
    }
    @Override
    public Map<ItemId, BigInteger> GetBuildCost() {
        return Map.of(ItemId.Wood, new BigInteger("40"),
                ItemId.Stone, new BigInteger("20"));
    }
}
