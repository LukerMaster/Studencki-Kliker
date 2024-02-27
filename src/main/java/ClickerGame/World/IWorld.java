package ClickerGame.World;

import ClickerGame.Actions.IUserAction;
import ClickerGame.Generators.IGenerator;

import java.util.List;

/**
 * The world of the game itself. This class contains all the states the game has.
 */
public interface IWorld {
    IInventory GetInventory();

    List<IUserAction> GetAvailableActions();
    List<IGenerator> GetActiveGenerators();
}
