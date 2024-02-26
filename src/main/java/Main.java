import CLI.CliGameWindow;
import Core.*;

import java.math.BigInteger;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameLoop gameLoop = new GameLoop(new Inventory());
        IGameWindow gameWindow = new CliGameWindow(gameLoop,
                ResourceBundle.getBundle("texts", Locale.getDefault()),
                ResourceBundle.getBundle("item_names", Locale.getDefault()));
        gameWindow.start();
    }
}