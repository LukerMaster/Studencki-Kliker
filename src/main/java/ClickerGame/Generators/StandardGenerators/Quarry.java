package ClickerGame.Generators.StandardGenerators;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class Quarry extends StandardGenerator {

    public Quarry(IInventory inventory) {
        super(inventory,
                Map.of(ItemId.Wood, new BigInteger("180"),
                        ItemId.Stone, new BigInteger("30"),
                        ItemId.Student, new BigInteger("1")),
                10,
                Map.of(ItemId.Beer, new BigInteger("1"), ItemId.Meat, new BigInteger("8")),
                Map.of(ItemId.Stone, new BigInteger("32")),
                3);
    }
}
