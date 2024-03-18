package ClickerGame.Generators.Components.Scrapping;

import ClickerGame.ItemId;
import ClickerGame.Localization.ScrappingTypeId;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Map;

public interface IScrappable extends Serializable {
    Map<ItemId, BigInteger> GetScrapValue();
    default ScrappingTypeId GetScrappingType()
    {
        return ScrappingTypeId.Demolish;
    }
}
