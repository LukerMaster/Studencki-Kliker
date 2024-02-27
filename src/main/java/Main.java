import CLI.CliClickerGameWindow;
import CLI.IInformationDisplayingStrategy;
import CLI.InlineInformationDisplayingStrategy;
import ClickerGame.ClickerGame;
import ClickerGame.Inventory;
import Core.*;
import ClickerGame.IStringsProvider;
import ClickerGame.StringsProvider;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    /**
     * Starts the program.
     */
    public static void main(String[] args) {
        /**
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

        IStringsProvider stringsProvider = new StringsProvider(ResourceBundle.getBundle("texts", Locale.getDefault()));

        ClickerGame gameLoop = new ClickerGame(new Inventory());

        IInformationDisplayingStrategy displayingStrategy = new InlineInformationDisplayingStrategy(gameLoop, stringsProvider);

        IProgramWindow gameWindow = new CliClickerGameWindow(gameLoop, displayingStrategy);

        gameWindow.Start();
    }
}