package ClickerGame.Generators.GenerationStrategies;

import ClickerGame.Generators.States.IState;
import ClickerGame.Generators.States.Running;
import ClickerGame.Generators.States.Waiting;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PeriodicAction implements IGeneration, IPeriodicProgressingAction
{
    float currentTime = 0;
    final float secondsBetweenSpawns;
    boolean isProducing = false;

    final Runnable OnFinish;
    final Runnable OnStart;
    final Supplier<Boolean> Requirement;

    IState currentState;

    transient List<Consumer<Float>> onProgressListeners = new ArrayList<>();

    public PeriodicAction(
            float secondsBetweenSpawns,
            Supplier<Boolean> requirement,
            Runnable onStart,
            Runnable onFinish)
    {
        currentState = new Waiting();
        this.secondsBetweenSpawns = secondsBetweenSpawns;
        OnStart = onStart;
        OnFinish = onFinish;
        Requirement = requirement;
    }
    @Override
    public void Update(float deltaTime) {

        if (Requirement.get() && !isProducing)
        {
            currentTime -= secondsBetweenSpawns;
            if (currentTime < 0) currentTime = 0;

            OnStart.run();
            isProducing = true;
            currentState = new Running();
        }

        if (isProducing)
        {
            currentTime += deltaTime;
            NotifyListeners();
            if (currentTime >= secondsBetweenSpawns)
            {
                OnFinish.run();
                isProducing = false;
                currentState = new Waiting();
                NotifyListeners();
            }
        }
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
        return currentTime / secondsBetweenSpawns;
    }

    @Override
    public float GetWorkTime() {
        return secondsBetweenSpawns;
    }
}
