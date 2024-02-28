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
        /*
         * Main method is currently used as a factory class to resolve all
         * dependencies / do IoC - In general: Build the program.
         *
         * Some people like to use dedicated factory classes for that, but
         * personally I find that redundant.
         *
         * Making a separate factory class just moves the code from Main.
         * It's even cleaner to create a seperate project
         * and reference the classes from Main there.
         *
         * There is argument for better configurability this way,
         * but if you're swapping entire program factory class, then
         * it's pretty much just a new program, and code redirection
         * is an anti-pattern that creates clutter.
        */

        // Technicals
        IStringsProvider stringsProvider = new StringsProvider(
                ResourceBundle.getBundle("texts", Locale.getDefault())
        );

        // Game Core
        IInventory inventory = new Inventory();

        List<ICustomUserAction> availableActions = new ArrayList<ICustomUserAction>();

        /*
        This could have been made with lambdas and would save myself adding a lot of simple classes.
        However I decided to keep it that way since this way I can treat those as NAMED functors.
        Savings done by lambdas would make this code way more cluttered.
         */
        availableActions.add(new ChopTree(inventory));
        availableActions.add(new CollectStones(inventory));

        IWorld world = new World(inventory, availableActions);

        GameLoop gameLoop = new GameLoop(world);

        // UI
        IInformationDisplaying displayingStrategy = new InformationDisplayingInTerminal(world, stringsProvider);
        IActionTaking actionTakingStrategy = new ActionTakingInTerminal(new Scanner(System.in), world);
        IProgramWindow gameWindow = new CliClickerGameWindow(
                gameLoop,
                displayingStrategy,
                actionTakingStrategy
        );

        gameWindow.Start();
    }
}