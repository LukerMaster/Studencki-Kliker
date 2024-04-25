package ClickerGame;

import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IWorld;
import Core.IGameLoop;

import java.util.concurrent.ConcurrentLinkedQueue;

public class GameLoop implements IGameLoop {
    final IWorld world;
    public GameLoop(IWorld world)
    {
        this.world = world;
    }

    public void Update(float deltaTime)
    {
        ConcurrentLinkedQueue<IGenerator> activeGenerators = world.GetActiveGenerators();

        activeGenerators.stream().forEach(gen -> gen.Update(deltaTime));
    }
}
