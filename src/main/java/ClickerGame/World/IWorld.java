package ClickerGame.World;

import ClickerGame.Actions.ICustomUserAction;
import ClickerGame.Generators.IGenerator;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * The world of the game itself. This class contains all the states the game has.
 */
public interface IWorld extends Serializable {
    IInventory GetInventory();
    List<ICustomUserAction> GetAvailableActions();
    void SetAvailableActions(List<ICustomUserAction> actions);
    ConcurrentLinkedQueue<IGenerator> GetActiveGenerators();
    void AddNewGenerator(IGenerator generator);
    void RemoveGenerator(IGenerator generator);
    void SetLastGameTime(Instant time);
    Instant GetLastGameTime();

    Random GetRng();
}
