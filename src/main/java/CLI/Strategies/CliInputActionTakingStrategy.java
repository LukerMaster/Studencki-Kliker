package CLI.Strategies;

import ClickerGame.Actions.IUserAction;
import ClickerGame.World.IWorld;

import java.util.List;
import java.util.Scanner;

public class CliInputActionTakingStrategy implements IActionTakingStrategy {

    Scanner scanner;
    IWorld world;

    public CliInputActionTakingStrategy(Scanner scanner, IWorld world)
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


        List<IUserAction> actions = world.GetAvailableActions();
        if (actionIdx == 0 || actionIdx > actions.size())
            return;

        actions.get(actionIdx-1).execute();
    }
}
