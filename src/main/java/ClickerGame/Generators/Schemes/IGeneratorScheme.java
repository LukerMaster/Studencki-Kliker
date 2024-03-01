package ClickerGame.Generators.Schemes;

import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;
import ClickerGame.World.IWorld;

import java.math.BigInteger;
import java.util.Dictionary;

/**
 * Interface for defining building costs for different kind of generators
 */
public interface IGeneratorScheme {
    Dictionary<ItemId, BigInteger> getCost();
    IGenerator buyGenerator(IWorld world);
}
