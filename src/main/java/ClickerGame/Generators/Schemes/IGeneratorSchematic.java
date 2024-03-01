package ClickerGame.Generators.Schemes;

import ClickerGame.Generators.GeneratorId;
import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;
import ClickerGame.World.IWorld;

import java.math.BigInteger;
import java.util.Dictionary;
import java.util.Map;

/**
 * Interface for defining building costs for different kind of generators
 */
public interface IGeneratorSchematic {
    Map<ItemId, BigInteger> getCost();

    GeneratorId getGeneratorId();
    IGenerator buyGenerator(IWorld world);
}
