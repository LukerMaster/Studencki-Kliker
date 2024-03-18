package ClickerGame.Generators.StandardGenerators;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class University extends StandardGenerator {
    public University(IInventory inventory) {
        super(inventory,
                Map.of(ItemId.Metal, new BigInteger("6000"),
                        ItemId.Wood, new BigInteger("500000"),
                        ItemId.Stone, new BigInteger("100000"),
                        ItemId.Student, new BigInteger("300")),
                240,
                Map.of(ItemId.Beer, new BigInteger("1200"),
                        ItemId.Vodka, new BigInteger("80"),
                        ItemId.Gold, new BigInteger("4000")),
                Map.of(ItemId.Student, new BigInteger("360")),
                4);
    }
}
