package ClickerGame.Generators;

import ClickerGame.Localization.StringId;

/**
 * Interface for creating all kinds of automatic resource generators.
 */
public interface IGenerator {

    GeneratorId GetGeneratorId();
    void Update(float deltaTime);

}
