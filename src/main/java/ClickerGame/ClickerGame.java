package ClickerGame;

public class ClickerGame implements IClickerGameLoop {

    IInventory inventory;
    public ClickerGame(IInventory inventory)
    {
        this.inventory = inventory;
    }

    public IInventory GetInventory()
    {
        return inventory;
    }

    public void Update(float deltaTime)
    {
    }
}
