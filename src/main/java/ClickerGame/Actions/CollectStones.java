package ClickerGame.Actions;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

public class CollectStones implements ICustomUserAction {

    final IInventory targetInventory;
    private float _multiplier;

    public CollectStones(IInventory targetInventory)
    {
        this.targetInventory = targetInventory;
    }

    @Override
    public void execute() {
        this.targetInventory.addItems(ItemId.Stone, (int)_multiplier);
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
