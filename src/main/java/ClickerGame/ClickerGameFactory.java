package ClickerGame;

import ClickerGame.Actions.ChopTree;
import ClickerGame.Actions.CollectStones;
import ClickerGame.Actions.ICustomUserAction;
import ClickerGame.Localization.IStringsProvider;
import ClickerGame.Localization.StringsProvider;
import ClickerGame.World.IInventory;
import ClickerGame.World.IWorld;
import ClickerGame.World.Inventory;
import ClickerGame.World.World;
import Core.IGameLoop;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class ClickerGameFactory {

    public IGameLoop CreateGameLoop()
    {
        // Technicals

        /* This, alongside many others (inventory, world, etc.)
         * although not implemented in a Singleton-y way
         * is in fact realizing the premise of a Singleton pattern.
         * A single object of a class for the entire lifetime of the program.
         *
         * This is done to avoid creating actual Singleton classes with
         * private constructors and static methods, as those are
         * in my opinion - a bad practice.
         *
         * Why: Lemme explain - Singletons are used to provide global
         * access to an object that is not then passed around in a natural
         * OOP fashion. This makes other classes tightly coupled to your
         * singleton class and also cannot be properly handled by IoC frameworks.
         * The idea of a singleton as a single object for entire
         * lifetime of a program makes a lot of sense - Singleton pattern does not.
         *
         * Since we have IoC, any class can be a singleton by just creating it once
         * at dependency-resolving stage. This is what is happening here.
         *
         * IoC frameworks often allow for registering things "as singletons" which does
         * exactly that without utilizing actual Singleton-pattern.
         */
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

        return new GameLoop(world);
    }
}
