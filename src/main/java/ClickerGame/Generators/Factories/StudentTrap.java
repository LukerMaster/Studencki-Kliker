package ClickerGame.Generators.Factories;

import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IInventory;

import java.util.Random;

public class StudentTrap implements IGeneratorFactory {

    final IInventory targetInventory;
    final Random rng;

    public StudentTrap(IInventory targetInventory, Random rng) {
        this.targetInventory = targetInventory;
        this.rng = rng;
    }

    @Override
    public IGenerator CreateGenerator() {
        return new ClickerGame.Generators.CustomGenerators.StudentTrap(rng, targetInventory);
    }


}
