import ClickerGame.*;
import ClickerGame.Actions.*;
import ClickerGame.Generators.BuildRecipes.DemoGenerator;
import ClickerGame.Generators.BuildRecipes.IBuildRecipe;
import ClickerGame.Generators.BuildRecipes.TreeFarm;
import Swing.Dashboards.Factories.CurrentGeneratorsFactory;
import Swing.Localization.*;
import ClickerGame.World.*;
import Core.*;
import Swing.ClickerWindow;
import Swing.Dashboards.Factories.AvailableActionsFactory;
import Swing.Dashboards.Factories.GeneratorBuyMenuFactory;
import Swing.Localization.GenerationPresenters.GenerationPresentingStrategy;
import Swing.Localization.GenerationPresenters.IGenerationPresentingStrategy;
import Swing.ObservableInventory;
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
        Random rng = new Random();

        ObservableInventory observableInventory = new ObservableInventory(new Inventory());

        /*
         * These two may be temporary solution. I like to separate classes into their interfaces.
         * This ensures that if I even need to split this class, I won't have to change any uses of the class.
         */
        IInventory inventory = observableInventory;
        IObservableItemsProvider observableItemsProvider = observableInventory;

        List<ICustomUserAction> availableActions = new ArrayList<>();

        /*
        This could have been made with lambdas and would save myself adding a lot of simple classes.
        However, I decided to keep it that way since this way I can treat those as NAMED functors.
        Savings done by lambdas would make this code way more cluttered.
         */
        availableActions.add(new ChopTree(inventory));
        availableActions.add(new CollectStones(inventory));
        availableActions.add(new HuntForSomething(inventory));
        availableActions.add(new SearchForPlants(inventory, rng));
        availableActions.add(new BrewBeer(inventory));

        IWorld world = new World(inventory, availableActions);

        IGameLoop gameLoop = new GameLoop(world);

        List<IBuildRecipe> schematics = new ArrayList<>();
        schematics.add(new DemoGenerator());
        schematics.add(new TreeFarm());

        // UI
        IClassToLocaleIdMapper localeMapper = new ClassToLocaleIdMapper();
        IGenerationPresentingStrategy generationPresentingStrategy = new GenerationPresentingStrategy();
        IStringsProvider stringsProvider = new StringsProvider(
                ResourceBundle.getBundle("texts", Locale.getDefault()),
                localeMapper,
                generationPresentingStrategy);

        IWorldEventHandler eventHandler = (IWorldEventHandler) world;


        List<IDashboardFactory> dashboardFactories = new ArrayList<>();
        dashboardFactories.add(new ResourcesDashboardFactory(stringsProvider, observableItemsProvider));
        dashboardFactories.add(new AvailableActionsFactory(stringsProvider, availableActions, observableInventory));
        dashboardFactories.add(new GeneratorBuyMenuFactory(schematics, world, observableItemsProvider, stringsProvider));
        dashboardFactories.add(new CurrentGeneratorsFactory(world, eventHandler, stringsProvider));

        IProgramWindow programWindow = new ClickerWindow(dashboardFactories, stringsProvider, gameLoop);
        programWindow.Start();
    }
}