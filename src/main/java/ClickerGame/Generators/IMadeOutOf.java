package ClickerGame.Generators;

import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public interface IMadeOutOf {
    Map<ItemId, BigInteger> GetWhatItsMadeOutOf();
}
