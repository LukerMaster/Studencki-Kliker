package ClickerGame.Generators.StandardGenerators;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class Butchery extends StandardGenerator {
    public Butchery(IInventory inventory) {
        super(inventory,
                Map.of(ItemId.Metal, new BigInteger("750"),
                        ItemId.Wood, new BigInteger("120000"),
                        ItemId.Stone, new BigInteger("20000"),
                        ItemId.Student, new BigInteger("60"))
                , 90,
                Map.of(ItemId.Meat, new BigInteger("600"),
                        ItemId.Beer, new BigInteger("10")),
                Map.of(ItemId.Meat, new BigInteger("1200")),
                3);
    }
}
