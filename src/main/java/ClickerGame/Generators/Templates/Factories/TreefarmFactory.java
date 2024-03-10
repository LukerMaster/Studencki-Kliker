package ClickerGame.Generators.Templates.Factories;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.PeriodicSpawning;
import ClickerGame.Generators.Generator;
import ClickerGame.Generators.Templates.GeneratorTemplate;
import ClickerGame.Generators.Templates.IGeneratorTemplate;
import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

import static ClickerGame.Localization.GeneratorId.Tree_farm;

public class TreefarmFactory implements ITemplateFactory {


    @Override
    public IGeneratorTemplate CreateTemplate() {
        Map<ItemId, BigInteger>  buildCost = Map.of(
            ItemId.Wood, new BigInteger("40"),
            ItemId.Stone, new BigInteger("20")
        );

        IGeneration generation = new PeriodicSpawning( 5, Map.of(
            ItemId.Wood, new BigInteger("10")
        ));

        return new GeneratorTemplate(() -> new Generator(Tree_farm, generation), buildCost, Tree_farm);
    }
}
