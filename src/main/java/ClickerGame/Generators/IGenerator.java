package ClickerGame.Generators;

/**
 * Interface for creating all kinds of automatic resource generators.
 */
public interface IGenerator {

    GeneratorId GetGeneratorId();
    void Update(float deltaTime);

}
