package CLI;

import Core.IGameLoop;
import Core.IProgramWindow;

import org.apache.commons.lang3.time.StopWatch;

public class CliClickerGameWindow implements IProgramWindow {

    IGameLoop gameLoop;

    IInformationDisplayingStrategy informationDisplayingStrategy;
    IActionTakingStrategy actionTakingStrategy;
    StopWatch stopwatch = new StopWatch();
    public CliClickerGameWindow(IGameLoop gameLoop,
                                IInformationDisplayingStrategy informationDisplayingStrategy,
                                IActionTakingStrategy actionTakingStrategy) {
        this.gameLoop = gameLoop;
        this.informationDisplayingStrategy = informationDisplayingStrategy;
        this.actionTakingStrategy = actionTakingStrategy;
    }

    public void Start() {

        stopwatch.start();
        while (true) {
            informationDisplayingStrategy.DisplayStats();
            actionTakingStrategy.HandleUserInput();
            System.nanoTime();
            gameLoop.Update(stopwatch.getTime() / 1000.0f);
            stopwatch.reset();
            stopwatch.start();
        }
    }

}
