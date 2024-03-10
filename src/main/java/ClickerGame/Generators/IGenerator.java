package ClickerGame.Generators;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.World.IInventory;

/**
 * Interface for creating all kinds of automatic resource generators.
 */
public interface IGenerator {

    void Update(float deltaTime, IInventory targetInventory);

    IGeneration GetGenerationStrategy();

}
