package ClickerGame.Generators.Components.MadeOutOf;

import ClickerGame.Generators.IMadeOutOf;
import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public class MadeOutOfComponent implements IMadeOutOf {

    private final Map<ItemId, BigInteger> _cost;

    public MadeOutOfComponent(Map<ItemId, BigInteger> cost)
    {
        _cost = cost;
    }
    @Override
    public Map<ItemId, BigInteger> GetWhatItsMadeOutOf() {
        return _cost;
    }
}
