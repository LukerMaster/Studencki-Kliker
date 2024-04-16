package ClickerGame.Actions;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.util.Random;

public class SearchForPlants implements ICustomUserAction {

    final IInventory targetInventory;

    final Random rng;
    private float _multiplier;

    public SearchForPlants(IInventory targetInventory, Random rng) {
        this.targetInventory = targetInventory;
        this.rng = rng;
    }

    @Override
    public void execute() {
        int rolled = rng.nextInt(0, 21);
        int potatoes = rolled / 10;
        targetInventory.addItems(ItemId.Potato, potatoes);

        int bound = 11.0f / _multiplier > 1 ? (int) (11.0f / _multiplier) : 1;

        boolean foundHops = rng.nextInt(0, 11) == 0;
        if (foundHops)
            targetInventory.addItems(ItemId.Hops, 1);
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
