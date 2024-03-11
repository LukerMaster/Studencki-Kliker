package ClickerGame.Generators.GenerationStrategies;

import ClickerGame.World.IInventory;

import java.io.Serializable;

public interface IGeneration extends Serializable {
    void Update(float deltaTime, IInventory targetInventory);
}
