package ClickerGame.Generators;

import ClickerGame.ItemId;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Map;

public interface IMadeOutOf extends Serializable {
    Map<ItemId, BigInteger> GetWhatItsMadeOutOf();
}
