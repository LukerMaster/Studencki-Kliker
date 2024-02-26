package Core;

import Core.IInventory;

import java.util.List;

public class GameLoop {

    IInventory inventory;
    public GameLoop(IInventory inventory)
    {
        this.inventory = inventory;
    }

    public IInventory getInventory()
    {
        return inventory;
    }

    public void update(float deltaTime)
    {
    }
}
