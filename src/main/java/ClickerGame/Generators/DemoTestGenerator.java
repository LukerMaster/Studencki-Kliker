package ClickerGame.Generators;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.PeriodicSpawningOneItem;
import ClickerGame.ItemId;
import ClickerGame.World.IWorld;

import java.math.BigInteger;

public class DemoTestGenerator implements IGenerator {
    private final IWorld world;

    public DemoTestGenerator(IWorld world)
    {

        this.world = world;
        this.spawning = new PeriodicSpawningOneItem(world,
                0.25f,
                ItemId.Gold,
                new BigInteger("750"));
    }
    IGeneration spawning;
    @Override
    public GeneratorId GetGeneratorId() {
        return GeneratorId.DemoTestGenerator;
    }

    @Override
    public void Update(float deltaTime) {
        spawning.Update(deltaTime);
    }
}
