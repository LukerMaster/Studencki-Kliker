package ClickerGame.Generators.Templates;

import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;
import ClickerGame.Localization.GeneratorId;

import java.math.BigInteger;
import java.util.Map;
import java.util.function.Supplier;

public interface IGeneratorTemplate {
    Supplier<IGenerator> GetGeneratorSupplier();
    GeneratorId GetGeneratorId();
    Map<ItemId, BigInteger> GetCost();
}