package ClickerGame.World;

import ClickerGame.Actions.ICustomUserAction;
import ClickerGame.Generators.IGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class World implements IWorld, IWorldEventHandler {

    private final List<ICustomUserAction> userActions;

    private List<Consumer<IGenerator>> onGeneratorAddEvents = new ArrayList<>();
    private List<Consumer<IGenerator>> onGeneratorRemoveEvents = new ArrayList<>();
    final IInventory inventory;

    private final List<IGenerator> activeGenerators = new ArrayList<>();

    public World(IInventory inventory, List<ICustomUserAction> userActions)
    {
        this.inventory = inventory;
        this.userActions = userActions;
    }

    @Override
    public IInventory GetInventory() {
        return inventory;
    }

    @Override
    public List<ICustomUserAction> GetAvailableActions() {
        return userActions;
    }

    @Override
    public List<IGenerator> GetActiveGenerators() {
        return Collections.unmodifiableList(activeGenerators);
    }

    @Override
    public void AddNewGenerator(IGenerator generator) {
        activeGenerators.add(generator);
        for (Consumer<IGenerator> onGeneratorAddEvent : onGeneratorAddEvents) {
            onGeneratorAddEvent.accept(generator);
        }
    }

    @Override
    public void RemoveGenerator(IGenerator generator) {
        for (Consumer<IGenerator> onGeneratorAddEvent : onGeneratorAddEvents) {
            onGeneratorAddEvent.accept(generator);
        }
        activeGenerators.remove(generator);
    }

    @Override
    public void AddListener_OnBeforeAddGenerator(Consumer<IGenerator> function) {
        onGeneratorAddEvents.add(function);
    }

    @Override
    public void AddListener_OnAfterRemoveGenerator(Consumer<IGenerator> function) {
        onGeneratorRemoveEvents.add(function);
    }
}
