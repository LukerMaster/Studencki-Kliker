package ClickerGame.Generators.Schemes;

import ClickerGame.Generators.GeneratorId;
import ClickerGame.Generators.IGenerator;
import ClickerGame.Generators.Treefarm;
import ClickerGame.ItemId;
import ClickerGame.World.IWorld;
import com.sun.source.tree.Tree;

import java.math.BigInteger;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

public class StandardTreefarm implements IGeneratorSchematic {
    @Override
    public Map<ItemId, BigInteger> getCost() {
        Map<ItemId, BigInteger> cost = new Hashtable<>();
        cost.put(ItemId.Wood, new BigInteger("40"));
        cost.put(ItemId.Stone, new BigInteger("20"));
        return cost;
    }

    @Override
    public GeneratorId getGeneratorId() {
        return GeneratorId.Treefarm;
    }

    @Override
    public IGenerator buyGenerator(IWorld world) {
        world.GetInventory().takeItems(getCost());
        return new Treefarm(world);
    }
}
