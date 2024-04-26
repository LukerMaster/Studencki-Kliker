package ClickerGame.Generators.GenerationStrategies;

import ClickerGame.Generators.States.IState;
import ClickerGame.Generators.States.Running;
import ClickerGame.Generators.States.Waiting;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PeriodicAction implements IPeriodicAction
{
    final Runnable OnFinish;
    final Runnable OnStart;
    final Supplier<Boolean> Requirement;

    float progress = 0;
    final float secondsBetweenSpawns;
    IState currentState;

    transient List<Consumer<Float>> onProgressListeners = new ArrayList<>();

    public PeriodicAction(
            float secondsBetweenSpawns,
            Supplier<Boolean> requirement,
            Runnable onStart,
            Runnable onFinish)
    {
        this.secondsBetweenSpawns = secondsBetweenSpawns;
        OnStart = onStart;
        OnFinish = onFinish;
        Requirement = requirement;
        var WaitingState = new Waiting(requirement);
        var RunningState = new Running(secondsBetweenSpawns,
                (Serializable & Consumer<Float>)(progress) -> this.progress = progress,
                onFinish);

        WaitingState.SetOnFinish((Serializable & Runnable)() -> {
            onStart.run();
            currentState = RunningState;
        });

        RunningState.SetOnFinish((Serializable & Runnable)() -> {
            currentState = WaitingState;
        });

        currentState = WaitingState;
    }
    @Override
    public void Update(float deltaTime) {
        currentState.Progress(deltaTime);
        NotifyListeners();
    }

    @Override
    public Runnable GetOnStart() {
        return OnStart;
    }

    @Override
    public Runnable GetOnFinish() {
        return OnFinish;
    }

    @Override
    public Supplier<Boolean> GetRequirement() {
        return Requirement;
    }

    @Override
    public IState GetState() {
        return currentState;
    }

    private void NotifyListeners()
    {
        if (onProgressListeners == null)
            onProgressListeners = new ArrayList<>();
        for (Consumer<Float> onProgressListener : onProgressListeners) {
            onProgressListener.accept(GetProgressToNextSpawn());
        }
    }
    @Override
    public void AddOnProgressChangeListener(Consumer<Float> function) {
        if (onProgressListeners == null)
            onProgressListeners = new ArrayList<>();

        onProgressListeners.add(function);
    }

    @Override
    public float GetProgressToNextSpawn() {
        return progress;
    }

    @Override
    public float GetWorkTime() {
        return secondsBetweenSpawns;
    }
}
