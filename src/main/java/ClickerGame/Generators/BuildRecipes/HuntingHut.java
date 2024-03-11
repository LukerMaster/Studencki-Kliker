package ClickerGame.Generators.BuildRecipes;

import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public class HuntingHut implements IBuildRecipe{
    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.HuntingHut();
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
