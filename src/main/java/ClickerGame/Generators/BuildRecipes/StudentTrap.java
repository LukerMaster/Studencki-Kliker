package ClickerGame.Generators.BuildRecipes;

import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;
import java.util.Random;

public class StudentTrap implements IBuildRecipe{

    final Random rng;

    public StudentTrap(Random rng) {
        this.rng = rng;
    }

    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.StudentTrap(rng);
    }

    @Override
    public Map<ItemId, BigInteger> GetBuildCost() {
        return Map.of(
                ItemId.Wood, new BigInteger("5"),
                ItemId.Beer, new BigInteger("1")
        );
    }
}
