package ClickerGame.Localization;

import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public interface IBuildCostPresenter {
    String PresentCostAsString(Map<ItemId, BigInteger> cost);
}
