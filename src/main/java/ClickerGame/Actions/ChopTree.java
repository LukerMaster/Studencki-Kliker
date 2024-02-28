package ClickerGame.Actions;

import ClickerGame.World.IInventory;
import ClickerGame.ItemId;

/*
 * This class (alongside others) may be named in a strange way,
 * however I decided that instead of naming them like "ChopTreeAction",
 * they are just in a package named "Actions", which explains their
 * purpose rather cleanly.
 */
public class ChopTree implements ICustomUserAction {

    IInventory userInventory;

    public ChopTree(IInventory userInventory) {
        this.userInventory = userInventory;
    }

    @Override
    public CustomActionId GetActionId() {
        return CustomActionId.Chop_a_tree;
    }

    @Override
    public void execute() {
        userInventory.addItems(ItemId.Wood, 1);
    }
}