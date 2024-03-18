package ClickerGame.Generators.StandardGenerators;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class Brewery extends StandardGenerator {
    public Brewery(IInventory inventory) {
        super(inventory,
                Map.of(ItemId.Wood, new BigInteger("750"),
                        ItemId.Stone, new BigInteger("450"),
                        ItemId.Student, new BigInteger("3")),
                10,
                Map.of(ItemId.Hops, new BigInteger("25"),
                        ItemId.Meat, new BigInteger("12")),
                Map.of(ItemId.Beer, new BigInteger("10")),
                3);
    }
}
