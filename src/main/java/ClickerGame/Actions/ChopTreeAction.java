package ClickerGame.Actions;

import ClickerGame.World.IInventory;
import ClickerGame.ItemId;
import ClickerGame.Localization.StringId;

public class ChopTreeAction implements IUserAction {

    IInventory userInventory;

    public ChopTreeAction(IInventory userInventory) {
        this.userInventory = userInventory;
    }

    @Override
    public StringId getInternalNameStringId() {
        return StringId.Chop_a_tree;
    }

    @Override
    public void execute() {
        userInventory.addItems(ItemId.Wood, 1);
    }
}
