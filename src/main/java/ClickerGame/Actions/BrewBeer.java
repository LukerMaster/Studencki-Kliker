package ClickerGame.Actions;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

public class BrewBeer implements ICustomUserAction {

    final IInventory userInventory;

    public BrewBeer(IInventory userInventory) {
        this.userInventory = userInventory;
    }

    @Override
    public void execute() {
        if (canExecute())
        {
            userInventory.takeItems(ItemId.Hops, 4);
            userInventory.addItems(ItemId.Beer, 1);
        }
        else throw new RuntimeException("Action called despite it being unavailable at the moment.");
    }

    @Override
    public boolean canExecute() {
        return userInventory.hasItems(ItemId.Hops, 4);
    }
}
