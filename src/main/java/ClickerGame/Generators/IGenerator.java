package ClickerGame.Generators;

import ClickerGame.Generators.GenerationStrategies.IGeneration;

import java.io.Serializable;

/**
 * Interface for creating all kinds of automatic resource generators.
 */
public interface IGenerator extends Serializable {

    default void Update(float deltaTime)
    {
        GetGenerationStrategy().Update(deltaTime);
    }
    IGeneration GetGenerationStrategy();

}
