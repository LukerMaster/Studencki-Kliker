package ClickerGame.Actions.CookieSpawning;

import ClickerGame.Actions.ICustomUserAction;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.util.Random;

public class CookieSpawnActionWrapper {

    private final Random rng;

    public CookieSpawnActionWrapper(Random rng) {
        this.rng = rng;
    }

    public ICustomUserAction WrapActionWithCookieSpawn(ICustomUserAction action, IInventory inventory)
    {
        String actionName = action.getName();
        return new ICustomUserAction() {
            @Override
            public void execute() {
                action.execute();
                int cookieAmount = CookieContainer.CreateRandomContainer(rng).GetCookies();
                inventory.addItems(ItemId.Cookie, cookieAmount);
            }

            @Override
            public boolean canExecute() {
                return action.canExecute();
            }

            @Override
            public String getName()
            {
                return actionName;
            }
        };
    }
}
