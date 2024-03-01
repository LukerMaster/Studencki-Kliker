package ClickerGame.Actions;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

public class CollectStones implements ICustomUserAction {

    final IInventory userInventory;

    public CollectStones(IInventory userInventory)
    {
        this.userInventory = userInventory;
    }

    @Override
    public CustomActionId GetActionId() {
        return CustomActionId.Collect_some_stones;
    }

    @Override
    public void execute() {
        this.userInventory.addItems(ItemId.Stone, 1);
    }
}
