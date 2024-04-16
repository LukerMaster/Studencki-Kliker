package ClickerGame.Actions;

import ClickerGame.World.IInventory;
import ClickerGame.ItemId;

/*
 * This class (alongside others) may be named in a strange way,
 * however I decided that instead of naming them like "ChopTreeAction",
 * they are just in a package named "Actions", which explains their
 * purpose rather cleanly.
 */
public class CollectWood implements ICustomUserAction {

    final IInventory targetInventory;
    private float _multiplier;

    public CollectWood(IInventory targetInventory) {
        this.targetInventory = targetInventory;
    }
    @Override
    public void execute() {
        targetInventory.addItems(ItemId.Wood, (int)_multiplier);
    }

    @Override
    public boolean canExecute() {
        return true;
    }

    @Override
    public void setPowerMultiplier(float value) {
        _multiplier = value;
    }
}
