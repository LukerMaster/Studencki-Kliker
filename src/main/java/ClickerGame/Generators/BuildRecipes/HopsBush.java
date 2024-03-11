package ClickerGame.Generators.BuildRecipes;

import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public class HopsBush implements IBuildRecipe {
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.HopsBush();
    }

    @Override
    public Map<ItemId, BigInteger> GetBuildCost() {
        return Map.of(ItemId.Hops, new BigInteger("2"),
                ItemId.Wood, new BigInteger("85"));
    }
}
