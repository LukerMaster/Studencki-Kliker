package ClickerGame.Generators.GenerationStrategies;

import java.io.Serializable;
import java.util.function.Supplier;

public interface IGeneration extends Serializable {
    void Update(float deltaTime);
    Runnable GetOnStart();
    Runnable GetOnFinish();
    Supplier<Boolean> GetRequirement();
}
