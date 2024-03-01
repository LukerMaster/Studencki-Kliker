package ClickerGame.Generators.Schemes;

import ClickerGame.Generators.IGenerator;
import ClickerGame.Generators.Treefarm;
import ClickerGame.ItemId;
import ClickerGame.World.IWorld;

import java.math.BigInteger;
import java.util.Dictionary;
import java.util.Hashtable;

public class StandardTreefarm implements IGeneratorScheme {
    @Override
    public Dictionary<ItemId, BigInteger> getCost() {
        Dictionary<ItemId, BigInteger> cost = new Hashtable<>();
        cost.put(ItemId.Wood, new BigInteger("40"));
        cost.put(ItemId.Stone, new BigInteger("20"));
        return cost;
    }

    @Override
    public IGenerator buyGenerator(IWorld world) {
        world.GetInventory().takeItems(getCost());
        return new Treefarm(world);
    }
}
