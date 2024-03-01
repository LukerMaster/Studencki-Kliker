package ClickerGame.Generators.Schemes;

import ClickerGame.Generators.DemoTestGenerator;
import ClickerGame.Generators.GeneratorId;
import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;
import ClickerGame.World.IWorld;

import java.math.BigInteger;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

public class DemoTest implements IGeneratorSchematic {
    @Override
    public Map<ItemId, BigInteger> getCost() {
        Map<ItemId, BigInteger> cost = new Hashtable<>();

        cost.put(ItemId.Wood, new BigInteger("2"));

        return cost;
    }

    @Override
    public GeneratorId getGeneratorId() {
        return GeneratorId.DemoTestGenerator;
    }

    @Override
    public IGenerator buyGenerator(IWorld world) {
        world.GetInventory().takeItems(getCost());
        return new DemoTestGenerator(world);
    }
}
