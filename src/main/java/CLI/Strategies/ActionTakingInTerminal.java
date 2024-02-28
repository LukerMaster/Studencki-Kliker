package CLI.Strategies;

import ClickerGame.Actions.ICustomUserAction;
import ClickerGame.World.IWorld;

import java.util.List;
import java.util.Scanner;

public class ActionTakingInTerminal implements IActionTaking {

    Scanner scanner;
    IWorld world;

    public ActionTakingInTerminal(Scanner scanner, IWorld world)
    {
        this.scanner = scanner;
        this.world = world;
    }

    @Override
    public void HandleUserInput() {

        String input = scanner.nextLine();

        int actionIdx;
        try
        {
            actionIdx = Integer.parseInt(input);
        }
        catch (NumberFormatException e)
        {
            return;
        }


        List<ICustomUserAction> actions = world.GetAvailableActions();
        if (actionIdx == 0 || actionIdx > actions.size())
            return;

        actions.get(actionIdx-1).execute();
    }
}
