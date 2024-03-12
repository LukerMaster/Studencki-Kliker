package ClickerGame.Generators.BuildRecipes;

import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class Brewery implements IBuildRecipe {

    final IInventory targetInventory;

    public Brewery(IInventory targetInventory) {
        this.targetInventory = targetInventory;
    }

    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.Brewery(targetInventory);
    }

    @Override
    public Map<ItemId, BigInteger> GetBuildCost() {
        return Map.of(
                ItemId.Wood, new BigInteger("750"),
                ItemId.Stone, new BigInteger("450"),
                ItemId.Student, new BigInteger("3")
        );
    }
}
