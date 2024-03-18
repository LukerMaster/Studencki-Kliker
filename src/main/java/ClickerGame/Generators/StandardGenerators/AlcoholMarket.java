package ClickerGame.Generators.StandardGenerators;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class AlcoholMarket extends StandardGenerator {
    public AlcoholMarket(IInventory inventory) {
        super(inventory,
                Map.of(ItemId.Metal, new BigInteger("320"),
                        ItemId.Wood, new BigInteger("17500"),
                        ItemId.Stone, new BigInteger("2000"),
                        ItemId.Student, new BigInteger("4")),
                45,
                Map.of(ItemId.Vodka, new BigInteger("10"),
                        ItemId.Meat, new BigInteger("6"),
                        ItemId.Beer, new BigInteger("6")),
                Map.of(ItemId.Gold, new BigInteger("250")),
                3);
    }
}
