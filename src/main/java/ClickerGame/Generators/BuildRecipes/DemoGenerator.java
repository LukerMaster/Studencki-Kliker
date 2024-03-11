package ClickerGame.Generators.BuildRecipes;

import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public class DemoGenerator implements IBuildRecipe {
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.DemoGenerator();
    }

    @Override
    public Map<ItemId, BigInteger> GetBuildCost() {
        return Map.of(ItemId.Wood, new BigInteger("1"));
    }
}
