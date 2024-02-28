package ClickerGame.Actions;

import ClickerGame.ItemId;
import ClickerGame.Localization.StringId;
import ClickerGame.World.IInventory;

public class CollectStones implements ICustomUserAction {

    IInventory userInventory;

    public CollectStones(IInventory userInventory)
    {
        this.userInventory = userInventory;
    }

    @Override
    public StringId GetActionNameId() {
        return StringId.Collect_some_stones;
    }

    @Override
    public void execute() {
        this.userInventory.addItems(ItemId.Stone, 1);
    }
}
