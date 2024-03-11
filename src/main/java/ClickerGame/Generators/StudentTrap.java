package ClickerGame.Generators;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.World.IInventory;

public class StudentTrap implements IGenerator {
    @Override
    public void Update(float deltaTime, IInventory targetInventory) {

    }

    @Override
    public IGeneration GetGenerationStrategy() {
        return null;
    }
}
