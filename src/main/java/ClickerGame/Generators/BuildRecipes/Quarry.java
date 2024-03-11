package ClickerGame.Generators.BuildRecipes;

import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public class Quarry implements IBuildRecipe {
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.Quarry();
    }

    @Override
    public Map<ItemId, BigInteger> GetBuildCost() {
        return Map.of(
                ItemId.Wood, new BigInteger("100"),
                ItemId.Stone, new BigInteger("20"),
                ItemId.Student, new BigInteger("1")
        );
    }
}
