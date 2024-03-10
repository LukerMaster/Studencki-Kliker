package ClickerGame.Actions;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

public class HuntForSomething implements ICustomUserAction {

    private final IInventory inventory;

    public HuntForSomething(IInventory inventory) {

        this.inventory = inventory;
    }
    @Override
    public void execute() {
        inventory.addItems(ItemId.Meat, 1);
    }
}
