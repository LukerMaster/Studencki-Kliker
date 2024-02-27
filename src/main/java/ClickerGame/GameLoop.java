package ClickerGame;

import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IWorld;
import Core.IGameLoop;

import java.util.List;

public class GameLoop implements IGameLoop {
    IWorld world;

    public GameLoop(IWorld world)
    {
        this.world = world;
    }

    public void Update(float deltaTime)
    {
        List<IGenerator> activeGenerators = world.GetActiveGenerators();

        for (IGenerator gen : activeGenerators)
            gen.Update(deltaTime);
    }
}
