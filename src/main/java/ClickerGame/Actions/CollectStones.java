package ClickerGame.Actions;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

public class CollectStones implements ICustomUserAction {

    final IInventory targetInventory;

    public CollectStones(IInventory targetInventory)
    {
        this.targetInventory = targetInventory;
    }

    @Override
    public void execute() {
        this.targetInventory.addItems(ItemId.Stone, 1);
    }

    @Override
    public boolean canExecute() {
        return true;
    }
}
