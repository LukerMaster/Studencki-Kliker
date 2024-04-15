package ClickerGame.Generators.States;


import java.util.function.Consumer;

public class Running implements IState {
    
    float currentTime = 0;
    
    final float secondsToFinish;
    private final Consumer<Float> onProgress;
    private final Runnable onTimePassed;
    private Runnable OnFinish;

    public Running(float secondsToFinish, Consumer<Float> onProgress, Runnable onTimePassed)
    {
        this.secondsToFinish = secondsToFinish;
        this.onProgress = onProgress;
        this.onTimePassed = onTimePassed;
    }
    
    @Override
    public String getName()
    {
        return "Running";
    }

    @Override
    public void Progress(float deltaTime) {
        currentTime += deltaTime;
        onProgress.accept(currentTime / secondsToFinish);
        if (currentTime >= secondsToFinish)
        {
            while (currentTime >= secondsToFinish)
            {
                currentTime -= secondsToFinish;
                onTimePassed.run();
            }
            OnFinish.run();
        }

    }

    @Override
    public void SetOnFinish(Runnable function) {
        this.OnFinish = function;
    }
}
