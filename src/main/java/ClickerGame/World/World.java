package ClickerGame.World;

import ClickerGame.Actions.ICustomUserAction;
import ClickerGame.Generators.IGenerator;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;

public class World implements IWorld, IWorldEventHandler {

    private transient List<ICustomUserAction> userActions;

    private transient List<Consumer<IGenerator>> onGeneratorAddEvents = new ArrayList<>();
    private transient List<Consumer<IGenerator>> onGeneratorRemoveEvents = new ArrayList<>();
    final IInventory inventory;

    private final ConcurrentLinkedQueue<IGenerator> activeGenerators = new ConcurrentLinkedQueue<>();
    private final Random rng;

    public World(IInventory inventory, List<ICustomUserAction> userActions, Random rng)
    {
        this.inventory = inventory;
        this.userActions = userActions;
        this.rng = rng;
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
    public void SetAvailableActions(List<ICustomUserAction> actions) {
        userActions = actions;
    }

    @Override
    public ConcurrentLinkedQueue<IGenerator> GetActiveGenerators() {
        return activeGenerators;
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
    public Random GetRng() {
        return rng;
    }

    @Override
    public void AddListener_OnBeforeAddGenerator(Consumer<IGenerator> function) {
        if (onGeneratorAddEvents == null)
            onGeneratorAddEvents = new ArrayList<>();
        onGeneratorAddEvents.add(function);
    }

    @Override
    public void AddListener_OnAfterRemoveGenerator(Consumer<IGenerator> function) {
        if (onGeneratorRemoveEvents == null)
            onGeneratorRemoveEvents = new ArrayList<>();
        onGeneratorRemoveEvents.add(function);
    }
}
