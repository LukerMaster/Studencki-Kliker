package CLI;

import ClickerGame.IClickerGameLoop;
import Core.IProgramWindow;
import ClickerGame.ItemId;

import java.util.ResourceBundle;
import java.util.Scanner;
import org.apache.commons.lang3.time.StopWatch;

public class CliClickerGameWindow implements IProgramWindow {

    IClickerGameLoop gameLoop;

    IInformationDisplayingStrategy informationDisplayingStrategy;
    StopWatch stopwatch = new StopWatch();
    public CliClickerGameWindow(IClickerGameLoop gameLoop, IInformationDisplayingStrategy informationDisplayingStrategy) {
        this.gameLoop = gameLoop;
        this.informationDisplayingStrategy = informationDisplayingStrategy;
    }

    public void Start() {

        stopwatch.start();
        while (true) {

            informationDisplayingStrategy.DisplayStats();

            Scanner s = new Scanner(System.in);
            String input = s.nextLine();
            System.nanoTime();

            gameLoop.Update(stopwatch.getTime() / 1000.0f);
            System.out.println("Elapesed:" + stopwatch.getTime() / 1000.0f);
            stopwatch.reset();
            stopwatch.start();
        }
    }

}
