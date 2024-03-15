package ClickerGame.Actions;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

public class BrewBeer implements ICustomUserAction {

    final IInventory targetInventory;

    public BrewBeer(IInventory targetInventory) {
        this.targetInventory = targetInventory;
    }

    @Override
    public void execute() {
        if (canExecute())
        {
            targetInventory.takeItems(ItemId.Hops, 4);
            targetInventory.addItems(ItemId.Beer, 1);
        }
        else throw new RuntimeException("Action called despite it being unavailable at the moment.");
    }

    @Override
    public boolean canExecute() {
        return targetInventory.hasItems(ItemId.Hops, 4);
    }
}
