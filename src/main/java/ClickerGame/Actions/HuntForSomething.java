package ClickerGame.Actions;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.util.Random;

public class HuntForSomething implements ICustomUserAction {

    private final IInventory targetInventory;
    private final Random rng;
    private float _multiplier;

    public HuntForSomething(IInventory targetInventory, Random rng) {

        this.targetInventory = targetInventory;
        this.rng = rng;
    }
    @Override
    public void execute() {
        // Tunable formula
        int bound = 3 - _multiplier > 1 ? (int) (3 - _multiplier) : 1;

        int rolled = rng.nextInt(0, bound);
        boolean success = rolled == 0;
        if (success)
            targetInventory.addItems(ItemId.Meat, (int) _multiplier);
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
