package Swing.Localization;

import ClickerGame.Actions.ChopTree;
import ClickerGame.Actions.CollectStones;
import ClickerGame.Actions.HuntForSomething;
import ClickerGame.Actions.ICustomUserAction;
import ClickerGame.Core.Generators.TreeFarm;
import ClickerGame.Generators.DemoGenerator;
import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.PeriodicSpawning;
import ClickerGame.Generators.IGenerator;
import Swing.Localization.GeneratorId;

public class ClassToLocaleIdMapper implements IClassToLocaleIdMapper {
    public GeneratorId GetIdOfGenerator(IGenerator generator)
    {
        if (generator.getClass().equals(TreeFarm.class)) return GeneratorId.Tree_farm;
        if (generator.getClass().equals(DemoGenerator.class)) return GeneratorId.DemoTestGenerator;
        throw new IllegalArgumentException("Unknown generator class");
    }
    public CustomActionId GetIdOfAction(ICustomUserAction action)
    {
        if (action.getClass().equals(ChopTree.class)) return CustomActionId.Chop_a_tree;
        if (action.getClass().equals(CollectStones.class)) return CustomActionId.Collect_some_stones;
        if (action.getClass().equals(HuntForSomething.class)) return CustomActionId.Hunt_for_something;
        throw new IllegalArgumentException("Unknown action class");
    }

    @Override
    public GenerationDescriptionId GetIdOfGeneration(IGeneration generation) {
        if (generation.getClass().equals(PeriodicSpawning.class)) return GenerationDescriptionId.Periodic_Spawning;
        throw new IllegalArgumentException("Unknown generation class");
    }
}
