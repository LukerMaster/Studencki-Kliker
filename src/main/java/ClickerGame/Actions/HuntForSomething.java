package ClickerGame.Actions;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.util.Random;

public class HuntForSomething implements ICustomUserAction {

    private final IInventory inventory;
    private final Random rng;

    public HuntForSomething(IInventory inventory, Random rng) {

        this.inventory = inventory;
        this.rng = rng;
    }
    @Override
    public void execute() {
        int rolled = rng.nextInt(0, 3);
        boolean success = rolled > 0;
        if (success)
            inventory.addItems(ItemId.Meat, 1);
    }

    @Override
    public boolean canExecute() {
        return true;
    }
}
