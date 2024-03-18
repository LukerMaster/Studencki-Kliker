package ClickerGame.Generators.StandardGenerators;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class Saturator extends StandardGenerator {
    public Saturator(IInventory inventory) {
        super(inventory,
                Map.of(ItemId.Metal, new BigInteger("25"),
                        ItemId.Wood, new BigInteger("2200"),
                        ItemId.Stone, new BigInteger("300"),
                        ItemId.Student, new BigInteger("2")),
                32,
                Map.of(ItemId.Potato, new BigInteger("80"),
                        ItemId.Meat, new BigInteger("10"),
                        ItemId.Beer, new BigInteger("5")),
                Map.of(ItemId.Vodka, new BigInteger("1")),
                3);
    }
}
