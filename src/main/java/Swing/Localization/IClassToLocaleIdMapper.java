package Swing.Localization;

import ClickerGame.Actions.ChopTree;
import ClickerGame.Actions.CollectStones;
import ClickerGame.Actions.HuntForSomething;
import ClickerGame.Actions.ICustomUserAction;
import ClickerGame.Generators.DemoGenerator;
import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.IGenerator;

import java.nio.file.FileStore;

public interface IClassToLocaleIdMapper {
    GeneratorId GetIdOfGenerator(IGenerator generator);
    CustomActionId GetIdOfAction(ICustomUserAction action);
    GenerationDescriptionId GetIdOfGeneration(IGeneration generation);
}
