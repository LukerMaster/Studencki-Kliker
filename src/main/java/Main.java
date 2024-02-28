import CLI.Strategies.ActionTakingInTerminal;
import CLI.Strategies.IActionTaking;
import CLI.Strategies.IInformationDisplaying;
import CLI.Strategies.InformationDisplayingInTerminal;
import ClickerGame.*;
import ClickerGame.Actions.ChopTree;
import ClickerGame.Actions.CollectStones;
import ClickerGame.Actions.ICustomUserAction;
import CLI.*;
import ClickerGame.Localization.IStringsProvider;
import ClickerGame.Localization.StringsProvider;
import ClickerGame.World.IInventory;
import ClickerGame.World.IWorld;
import ClickerGame.World.Inventory;
import ClickerGame.World.World;
import Core.*;

import java.util.*;

public class Main {
    /**
     * Starts the program.
     */
    public static void main(String[] args) {

        // UI
        IInformationDisplaying displayingStrategy = new InformationDisplayingInTerminal(world, stringsProvider);
        IActionTaking actionTakingStrategy = new ActionTakingInTerminal(new Scanner(System.in), world);
        IProgramWindow gameWindow = new CliClickerGameWindow(
                gameLoop,
                displayingStrategy,
                actionTakingStrategy
        );

        // Start
        gameWindow.Start();
    }
}