package ClickerGame.Generators.Templates;

import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;
import ClickerGame.Localization.GeneratorId;

import java.math.BigInteger;
import java.util.Map;
import java.util.function.Supplier;

public class GeneratorTemplate implements IGeneratorTemplate {

    Supplier<IGenerator> generatorSupplier;
    Map<ItemId, BigInteger> cost;
    private final GeneratorId generatorId;

    public GeneratorTemplate(Supplier<IGenerator> generatorSupplier,
                             Map<ItemId, BigInteger> cost,
                             GeneratorId generatorId) {
        this.generatorSupplier = generatorSupplier;
        this.cost = cost;
        this.generatorId = generatorId;
    }
    @Override
    public Supplier<IGenerator> GetGeneratorSupplier() {
        return generatorSupplier;
    }

    @Override
    public GeneratorId GetGeneratorId() {
        return generatorId;
    }

    @Override
    public Map<ItemId, BigInteger> GetCost() {
        return cost;
    }
}
