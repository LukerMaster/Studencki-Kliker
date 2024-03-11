import ClickerGame.*;
import ClickerGame.Actions.*;
import ClickerGame.Generators.BuildRecipes.*;
import ClickerGame.Localization.IStringsProvider;
import ClickerGame.Localization.StringsProvider;
import SaveSystem.IGameSaver;
import SaveSystem.IWorldFactory;
import SaveSystem.SaveBasedWorldFactory;
import Swing.Dashboards.Factories.CurrentGeneratorsFactory;
import ClickerGame.World.*;
import Core.*;
import Swing.ClickerWindow;
import Swing.Dashboards.Factories.AvailableActionsFactory;
import Swing.Dashboards.Factories.GeneratorBuyMenuFactory;
import ClickerGame.Localization.GenerationPresenters.GenerationPresentingStrategy;
import ClickerGame.Localization.GenerationPresenters.IGenerationPresentingStrategy;
import Swing.Dashboards.Factories.ResourcesDashboardFactory;
import Swing.Dashboards.IDashboardFactory;

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
         * It's even cleaner to create a separate project
         * and reference the classes from Main there.
         *
         * There is argument for better configurability this way,
         * but if you're swapping entire program factory class, then
         * it's pretty much just a new program, and code redirection
         * is an anti-pattern that creates clutter.
        */

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
        // Game Core
        IWorldFactory worldProvider = new SaveBasedWorldFactory("save.kekw");
        IGameSaver gameSaver = (IGameSaver)worldProvider;

        IWorld world = worldProvider.GetWorld();

        IInventory inventory = world.GetInventory();
        IObservableItemsProvider observableItemsProvider = (IObservableItemsProvider)inventory;
        List<ICustomUserAction> availableActions = world.GetAvailableActions();

        List<IBuildRecipe> buildRecipes = new ArrayList<>();
        //buildRecipes.add(new DemoGenerator());
        buildRecipes.add(new TreeFarm());
        buildRecipes.add(new HopsBush());
        buildRecipes.add(new StudentTrap(world.GetRng()));
        buildRecipes.add(new Quarry());
        buildRecipes.add(new HopsFarm());
        buildRecipes.add(new Brewery());
        buildRecipes.add(new HuntingHut());

        IGameLoop gameLoop = new GameLoop(world);
        //
        IGenerationPresentingStrategy generationPresentingStrategy = new GenerationPresentingStrategy();
        IStringsProvider stringsProvider = new StringsProvider(
                ResourceBundle.getBundle("texts", Locale.getDefault()),
                generationPresentingStrategy);

        IWorldEventHandler eventHandler = (IWorldEventHandler) world;


        List<IDashboardFactory> dashboardFactories = new ArrayList<>();
        dashboardFactories.add(new ResourcesDashboardFactory(stringsProvider, observableItemsProvider));
        dashboardFactories.add(new AvailableActionsFactory(stringsProvider, availableActions, observableItemsProvider));
        dashboardFactories.add(new GeneratorBuyMenuFactory(buildRecipes, world, observableItemsProvider, stringsProvider));
        dashboardFactories.add(new CurrentGeneratorsFactory(world, eventHandler, stringsProvider));

        IProgramWindow programWindow = new ClickerWindow(dashboardFactories, stringsProvider, gameLoop, gameSaver);
        programWindow.Start();
    }
}