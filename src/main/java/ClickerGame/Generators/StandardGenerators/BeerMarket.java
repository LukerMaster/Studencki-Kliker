package ClickerGame.Generators.StandardGenerators;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class BeerMarket extends StandardGenerator {
    public BeerMarket(IInventory inventory) {
        super(inventory,
                Map.of(ItemId.Metal, new BigInteger("6000"),
                        ItemId.Wood, new BigInteger("295000"),
                        ItemId.Stone, new BigInteger("40000"),
                        ItemId.Student, new BigInteger("220")),
                60,
                Map.of(ItemId.Beer, new BigInteger("1000"),
                        ItemId.Gold, new BigInteger("2000")),
                Map.of(ItemId.Gold, new BigInteger("52000")),
                3);
    }
}
