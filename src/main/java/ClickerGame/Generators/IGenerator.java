package ClickerGame.Generators;

import ClickerGame.Localization.GeneratorId;
import ClickerGame.World.IInventory;

/**
 * Interface for creating all kinds of automatic resource generators.
 */
public interface IGenerator {

    GeneratorId GetGeneratorId();
    void Update(float deltaTime, IInventory targetInventory);

}
