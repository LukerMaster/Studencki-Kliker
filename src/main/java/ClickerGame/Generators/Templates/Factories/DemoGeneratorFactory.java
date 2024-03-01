package ClickerGame.Generators.Templates.Factories;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.PeriodicSpawning;
import ClickerGame.Generators.Generator;
import ClickerGame.Generators.Templates.GeneratorTemplate;
import ClickerGame.Generators.Templates.IGeneratorTemplate;
import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

import static ClickerGame.Localization.GeneratorId.DemoTestGenerator;
import static ClickerGame.Localization.GeneratorId.Treefarm;

public class DemoGeneratorFactory implements ITemplateFactory{
    @Override
    public IGeneratorTemplate CreateTemplate() {
        Map<ItemId, BigInteger> buildCost = Map.of(
                ItemId.Wood, new BigInteger("2")
        );

        IGeneration generation = new PeriodicSpawning( 0.5f, Map.of(
                ItemId.Gold, new BigInteger("750")
        ));

        return new GeneratorTemplate(() -> new Generator(DemoTestGenerator, generation), buildCost, DemoTestGenerator);
    }
}
