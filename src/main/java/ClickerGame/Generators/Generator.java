package ClickerGame.Generators;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Localization.GeneratorId;
import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IInventory;

public class Generator implements IGenerator {

    private final GeneratorId id;
    private final IGeneration generationStrategy;

    public Generator(GeneratorId id, IGeneration generationStrategy) {
        this.id = id;
        this.generationStrategy = generationStrategy;
    }
    @Override
    public GeneratorId GetGeneratorId() {
        return id;
    }

    @Override
    public void Update(float deltaTime, IInventory targetInventory) {
        generationStrategy.Update(deltaTime, targetInventory);
    }
}
