package ClickerGame.Generators.StandardGenerators.GeneratorBuilder;

import ClickerGame.Generators.IGenerator;
import ClickerGame.Generators.StandardGenerators.StandardGenerator;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class GeneratorBuilder {

    private Map<ItemId, BigInteger> _cost;
    private Map<ItemId, BigInteger> _itemsSpawned;
    private float _secondsBetweenSpawns;
    private Map<ItemId, BigInteger> _itemsNecessary;
    private IInventory _inventory;
    private int _scrappingDivisor;

    public GeneratorBuilder setItemsSpawned(Map<ItemId, BigInteger> value)
    {
        _itemsSpawned = value;
        return this;
    }
    public GeneratorBuilder setItemsNecessary(Map<ItemId, BigInteger> value)
    {
        _itemsNecessary = value;
        return this;
    }
    public GeneratorBuilder setSecondsBetweenSpawns(float time)
    {
        _secondsBetweenSpawns = time;
        return this;
    }
    public GeneratorBuilder setMadeOutOf(Map<ItemId, BigInteger> cost)
    {
        _cost = cost;
        return this;
    }
    public GeneratorBuilder setInventory(IInventory inventory)
    {
        _inventory = inventory;
        return this;
    }
    public GeneratorBuilder setScrappingDivisor(int divisor)
    {
        _scrappingDivisor = divisor;
        return this;
    }
    public IGenerator build()
    {
        return new StandardGenerator(_inventory,
                _cost,
                _secondsBetweenSpawns,
                _itemsNecessary,
                _itemsSpawned,
                _scrappingDivisor);
    }

}
