package ClickerGame.Actions;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.util.Random;

public class SearchForPlants implements ICustomUserAction{

    final IInventory userInventory;

    final Random rng;

    public SearchForPlants(IInventory userInventory, Random rng) {
        this.userInventory = userInventory;
        this.rng = rng;
    }

    @Override
    public void execute() {
        int rolled = rng.nextInt(0, 21);
        int potatoes = rolled / 20;
        userInventory.addItems(ItemId.Potato, potatoes);

        boolean foundHops = rng.nextInt(0, 51) == 50;
        if (foundHops)
            userInventory.addItems(ItemId.Hops, 1);
    }

    @Override
    public boolean canExecute() {
        return false;
    }
}
