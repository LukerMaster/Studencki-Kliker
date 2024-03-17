package ClickerGame.Generators.Components.Scrapping;

import ClickerGame.ItemId;
import ClickerGame.Localization.ScrappingTypeId;

import java.math.BigInteger;
import java.util.Map;

public interface IScrappable {
    default Map<ItemId, BigInteger> GetScrapValue()
    {
        return Map.of();
    }
    default ScrappingTypeId GetScrappingType()
    {
        return ScrappingTypeId.Demolish;
    }
}
