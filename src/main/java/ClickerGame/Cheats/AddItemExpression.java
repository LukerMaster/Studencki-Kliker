package ClickerGame.Cheats;

import ClickerGame.ItemId;
import ClickerGame.World.IWorld;

public class AddItemExpression implements IExpression {

    private final String action;
    private final String item;
    private final int amount;

    public AddItemExpression(String action, String item, int amount)
    {
        this.action = action;
        this.item = item;
        this.amount = amount;
    }


    @Override
    public void interpret(IWorld world) {
        ItemId itemId = ItemId.valueOf(item);

        if (action.toLowerCase().equals("add")) {
            world.GetInventory().addItems(itemId, amount);
        }
        if (action.toLowerCase().equals("remove"))
        {
            if (world.GetInventory().hasItems(itemId, amount))
                world.GetInventory().takeItems(itemId, amount);
            else
                world.GetInventory().takeItems(itemId, world.GetInventory().getCount(itemId));
        }
    }
}
