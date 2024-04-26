package ClickerGame.World;

import ClickerGame.Actions.ICustomUserAction;
import ClickerGame.Generators.IGenerator;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;

public class World implements IWorld, IWorldEventHandler {

    private float _actionMultiplier = 1.0f;
    private float _buildingMultiplier = 1.0f;
    private final float _minMultiplier = 0.1f;

    private transient List<ICustomUserAction> userActions;
    private transient List<Consumer<IGenerator>> onGeneratorAddEvents = new ArrayList<>();
    private transient List<Consumer<IGenerator>> onGeneratorRemoveEvents = new ArrayList<>();
    final IInventory inventory;

    private final ConcurrentLinkedQueue<IGenerator> activeGenerators = new ConcurrentLinkedQueue<>();
    private final Random rng;
    private Instant LastGameTime;

    public World(IInventory inventory, List<ICustomUserAction> userActions, Random rng)
    {
        this.inventory = inventory;
        this.userActions = userActions;
        this.rng = rng;
        SetActionMultiplier(GetActionMultiplier());
        SetBuildingMultiplier(GetBuildingMultiplier());
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
    public void SetAvailableActions(List<ICustomUserAction> actions) { userActions = actions; }

    @Override
    public ConcurrentLinkedQueue<IGenerator> GetActiveGenerators() {
        return activeGenerators;
    }

    @Override
    public void AddNewGenerator(IGenerator generator) {
        activeGenerators.add(generator);
        if (onGeneratorAddEvents == null) onGeneratorAddEvents = new ArrayList<>();
        for (Consumer<IGenerator> onGeneratorAddEvent : onGeneratorAddEvents) {
            onGeneratorAddEvent.accept(generator);
        }
    }

    @Override
    public void RemoveGenerator(IGenerator generator) {
        if (onGeneratorRemoveEvents == null) onGeneratorRemoveEvents = new ArrayList<>();
        for (Consumer<IGenerator> onGeneratorRemoveEvent : onGeneratorRemoveEvents) {
            onGeneratorRemoveEvent.accept(generator);
        }
        activeGenerators.remove(generator);
    }

    @Override
    public void SetLastGameTime(Instant time) {
        LastGameTime = time;
    }

    @Override
    public Instant GetLastGameTime() {
        return LastGameTime;
    }

    @Override
    public float GetActionMultiplier() {
        return _actionMultiplier;
    }

    @Override
    public void SetActionMultiplier(float value) {
        _actionMultiplier = value;
        if (_actionMultiplier < _minMultiplier) _actionMultiplier = _minMultiplier;
        for (var action : userActions)
        {
            action.setPowerMultiplier(_actionMultiplier);
        }
    }

    @Override
    public float GetBuildingMultiplier() {
        return _buildingMultiplier;
    }

    @Override
    public void SetBuildingMultiplier(float value) {
        _buildingMultiplier = value;
        if (_buildingMultiplier < _minMultiplier) _buildingMultiplier = _minMultiplier;
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
