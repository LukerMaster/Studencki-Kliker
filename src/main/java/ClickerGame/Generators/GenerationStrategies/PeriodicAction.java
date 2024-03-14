package ClickerGame.Generators.GenerationStrategies;

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
    }
    @Override
    public void Update(float deltaTime) {

        if (Requirement.get() && !isProducing)
        {
            OnStart.run();
            isProducing = true;
        }

        if (isProducing)
        {
            currentTime += deltaTime;
            NotifyListeners();
            if (currentTime >= secondsBetweenSpawns)
            {
                OnFinish.run();
                currentTime -= secondsBetweenSpawns;
                isProducing = false;
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
