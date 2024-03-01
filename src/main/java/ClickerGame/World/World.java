package ClickerGame.World;

import ClickerGame.Actions.ICustomUserAction;
import ClickerGame.Generators.IGenerator;

import java.util.ArrayList;
import java.util.List;

public class World implements IWorld {

    private final List<ICustomUserAction> userActions;
    final IInventory inventory;

    private final List<IGenerator> activeGenerators = new ArrayList<>();

    public World(IInventory inventory, List<ICustomUserAction> userActions)
    {
        this.inventory = inventory;
        this.userActions = userActions;
    }

    @Override
    public IInventory GetInventory() {
        return inventory;
    }

    @Override
    public List<ICustomUserAction> GetAvailableActions() {
        return userActions;
    }

    @Override
    public List<IGenerator> GetActiveGenerators() {
        return activeGenerators;
    }
}
