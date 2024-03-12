package ClickerGame.Generators.GenerationStrategies;

import java.util.function.Consumer;

public interface IPeriodicProgressingAction {

    void AddOnProgressChangeListener(Consumer<Float> function);
    float GetProgressToNextSpawn();
    float GetWorkTime();
}
