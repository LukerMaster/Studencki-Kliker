package ClickerGame.Generators;

import ClickerGame.Generators.GenerationStrategies.ChanceBasedSpawning;
import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;
import java.util.Random;

public class StudentTrap implements IGenerator {


    final IGeneration generationStrategy;
    public StudentTrap(Random rng) {
        this.generationStrategy = new ChanceBasedSpawning(
                15,
                0.2f,
                Map.of(ItemId.Student, new BigInteger("1")),
                Map.of(ItemId.Beer, new BigInteger("1")),
                rng);
    }


    @Override
    public IGeneration GetGenerationStrategy() {
        return generationStrategy;
    }
}
