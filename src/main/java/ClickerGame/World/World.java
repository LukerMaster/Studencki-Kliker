package ClickerGame.World;

import ClickerGame.Actions.IUserAction;
import ClickerGame.Generators.IGenerator;

import java.util.ArrayList;
import java.util.List;

public class World implements IWorld {

    private final List<IUserAction> userActions;
    IInventory inventory;

    private final List<IGenerator> activeGenerators = new ArrayList<IGenerator>();

    public World(IInventory inventory, List<IUserAction> userActions)
    {
        this.inventory = inventory;
        this.userActions = userActions;
    }

    @Override
    public IInventory GetInventory() {
        return inventory;
    }

    @Override
    public List<IUserAction> GetAvailableActions() {
        return userActions;
    }

    @Override
    public List<IGenerator> GetActiveGenerators() {
        return activeGenerators;
    }
}
