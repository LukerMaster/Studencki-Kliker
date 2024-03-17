package ClickerGame.Generators.Components.Scrapping;

import ClickerGame.Generators.IMadeOutOf;
import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class ScrappingForFractionOfCost implements IScrappable {
    private final IMadeOutOf building;

    private final int divisor;
    public ScrappingForFractionOfCost(IMadeOutOf building, int divisor) {
        this.building = building;
        this.divisor = divisor;
    }

    @Override
    public Map<ItemId, BigInteger> GetScrapValue() {
        Map<ItemId, BigInteger> value = new HashMap<>();
        for (Map.Entry<ItemId, BigInteger> entry : building.GetWhatItsMadeOutOf().entrySet())
        {
            if (entry.getKey() != ItemId.Student)
            {
                value.put(entry.getKey(), entry.getValue().divide(new BigInteger(Integer.toString(divisor))));
            }
            value.put(entry.getKey(), entry.getValue());
        }
        return value;
    }
}
