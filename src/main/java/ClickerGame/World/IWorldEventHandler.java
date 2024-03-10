package ClickerGame.World;

import ClickerGame.Generators.IGenerator;

import java.util.function.Consumer;

public interface IWorldEventHandler {
    void AddListener_OnBeforeAddGenerator(Consumer<IGenerator> function);
    void AddListener_OnAfterRemoveGenerator(Consumer<IGenerator> function);
}
