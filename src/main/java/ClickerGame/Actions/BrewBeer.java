package ClickerGame.Actions;

import ClickerGame.Actions.Exceptions.UnavailableActionException;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

public class BrewBeer implements ICustomUserAction {

    final IInventory targetInventory;
    private float _multiplier;

    public BrewBeer(IInventory targetInventory) {
        this.targetInventory = targetInventory;
    }

    @Override
    public void execute() {
        if (canExecute())
        {
            targetInventory.takeItems(ItemId.Hops, 4 * (int)_multiplier);
            targetInventory.addItems(ItemId.Beer, (int) _multiplier);
        }
        else throw new UnavailableActionException("Action called despite it being unavailable at the moment.");
    }

    @Override
    public boolean canExecute() {
        return targetInventory.hasItems(ItemId.Hops, 4);
    }

    @Override
    public void setPowerMultiplier(float value) {
        _multiplier = value;
    }
}
