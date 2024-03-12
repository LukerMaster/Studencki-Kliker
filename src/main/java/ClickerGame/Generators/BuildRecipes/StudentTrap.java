package ClickerGame.Generators.BuildRecipes;

import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;
import java.util.Random;

public class StudentTrap implements IBuildRecipe {

    final IInventory targetInventory;
    final Random rng;

    public StudentTrap(IInventory targetInventory, Random rng) {
        this.targetInventory = targetInventory;
        this.rng = rng;
    }

    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.StudentTrap(rng, targetInventory);
    }

    @Override
    public Map<ItemId, BigInteger> GetBuildCost() {
        return Map.of(
                ItemId.Wood, new BigInteger("5"),
                ItemId.Beer, new BigInteger("1")
        );
    }
}
