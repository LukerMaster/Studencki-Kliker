package ClickerGame.Generators.BuildRecipes;

import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public interface IBuildRecipe {
    IGenerator CreateGenerator();

    Map<ItemId, BigInteger> GetBuildCost();
}
