package ClickerGame.World;

import ClickerGame.Actions.IUserAction;
import ClickerGame.Generators.IGenerator;

import java.util.List;

/**
 * Game state represents the world of the game itself.
 */
public interface IWorld {
    IInventory GetInventory();

    List<IUserAction> GetAvailableActions();
    List<IGenerator> GetActiveGenerators();
}
