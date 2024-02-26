package CLI;

import Core.GameLoop;
import Core.IGameWindow;
import Core.ItemId;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import org.apache.commons.lang3.time.StopWatch;

public class CliGameWindow implements IGameWindow {

    GameLoop gameLoop;

    ResourceBundle textsBundle;
    ResourceBundle itemsBundle;

    StopWatch stopwatch = new StopWatch();
    public CliGameWindow(GameLoop gameLoop, ResourceBundle textsBundle, ResourceBundle itemsBundle) {
        this.gameLoop = gameLoop;
        this.textsBundle = textsBundle;
        this.itemsBundle = itemsBundle;
    }

    public void start() {

        stopwatch.start();
        while (true) {
            System.out.println(textsBundle.getString("your_resources") + ":");

            for (ItemId id : ItemId.values())
                System.out.println(itemsBundle.getString(id.name()) + ": " + gameLoop.getInventory().getCount(id));

            System.out.println(textsBundle.getString("what_to_do_next"));

            Scanner s = new Scanner(System.in);
            String input = s.nextLine();
            System.nanoTime();

            gameLoop.update(stopwatch.getTime() / 1000.0f);
            System.out.println("Elapesed:" + stopwatch.getTime() / 1000.0f);
            stopwatch.reset();
            stopwatch.start();
        }
    }

}
