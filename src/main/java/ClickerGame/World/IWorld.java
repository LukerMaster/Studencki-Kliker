package ClickerGame.World;

import ClickerGame.Actions.ICustomUserAction;
import ClickerGame.Generators.IGenerator;

import java.util.List;

/**
 * The world of the game itself. This class contains all the states the game has.
 */
public interface IWorld {
    IInventory GetInventory();
    List<ICustomUserAction> GetAvailableActions();
    List<IGenerator> GetActiveGenerators();
    void AddNewGenerator(IGenerator generator);
    void RemoveGenerator(IGenerator generator);
}
