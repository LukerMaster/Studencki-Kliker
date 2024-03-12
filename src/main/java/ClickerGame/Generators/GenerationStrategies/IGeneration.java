package ClickerGame.Generators.GenerationStrategies;

import ClickerGame.World.IInventory;

import java.io.Serializable;
import java.util.function.Supplier;

public interface IGeneration extends Serializable {
    void Update(float deltaTime, IInventory targetInventory);
    Runnable GetOnStart();
    Runnable GetOnFinish();
    Supplier<Boolean> GetRequirement();
}
