package ClickerGame.Generators.BuildRecipes;

import ClickerGame.Generators.HuntingHut;
import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public class MeatFarm implements IBuildRecipe{
    @Override
    public IGenerator CreateGenerator() {
        return new HuntingHut();
    }

    @Override
    public Map<ItemId, BigInteger> GetBuildCost() {
        return Map.of(
                ItemId.Wood, new BigInteger("380"),
                ItemId.Stone, new BigInteger("220"),
                ItemId.Student, new BigInteger("3")
        );
    }
}
