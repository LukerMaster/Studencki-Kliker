package ClickerGame.Actions;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;
import ClickerGame.World.IWorld;

public class HuntForSomething implements ICustomUserAction {

    private final IInventory inventory;

    public HuntForSomething(IInventory inventory) {

        this.inventory = inventory;
    }
    @Override
    public CustomActionId GetActionId() {
        return CustomActionId.Hunt_for_something;
    }

    @Override
    public void execute() {
        inventory.addItems(ItemId.Meat, 1);
    }
}
