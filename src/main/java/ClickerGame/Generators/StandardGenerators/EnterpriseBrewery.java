package ClickerGame.Generators.StandardGenerators;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class EnterpriseBrewery extends StandardGenerator {
    public EnterpriseBrewery(IInventory inventory) {
        super(inventory,
                Map.of(ItemId.Metal, new BigInteger("10000"),
                        ItemId.Wood, new BigInteger("850000"),
                        ItemId.Stone, new BigInteger("250000"),
                        ItemId.Student, new BigInteger("300")),
                8,
                Map.of(ItemId.Gold, new BigInteger("2000"),
                        ItemId.Hops, new BigInteger("2000")),
                Map.of(ItemId.Beer, new BigInteger("1000")),
                3);
    }
}
