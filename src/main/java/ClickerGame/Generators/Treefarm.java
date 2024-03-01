package ClickerGame.Generators;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.PeriodicSpawning;
import ClickerGame.ItemId;
import ClickerGame.World.IWorld;

import java.math.BigInteger;

public class Treefarm implements IGenerator
{
    final IGeneration strategy;
    final IWorld world;
    public Treefarm(IWorld world)
    {
        this.world = world;
        this.strategy = new PeriodicSpawning(world,
                10,
                ItemId.Wood,
                new BigInteger("10"));
    }

    @Override
    public GeneratorId GetGeneratorId() {
        return GeneratorId.Treefarm;
    }

    @Override
    public void Update(float deltaTime) {
        strategy.Update(deltaTime);
    }
}
