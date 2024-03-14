package ClickerGame.Generators.Scraping;

import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public interface IScrappable {
    Map<ItemId, BigInteger> GetScrapValue();
}
