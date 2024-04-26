package ClickerGame.Generators.Components.MadeOutOf;

import ClickerGame.Generators.IMadeOutOf;
import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public class MadeOutOf implements IMadeOutOf {

    private final Map<ItemId, BigInteger> _cost;

    public MadeOutOf(Map<ItemId, BigInteger> cost)
    {
        _cost = cost;
    }
    @Override
    public Map<ItemId, BigInteger> GetWhatItsMadeOutOf() {
        return _cost;
    }
}
