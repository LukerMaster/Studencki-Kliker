package ClickerGame.Generators.GenerationStrategies;

import ClickerGame.World.IInventory;

public interface IGeneration {
    void Update(float deltaTime, IInventory targetInventory);
}
