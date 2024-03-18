package ClickerGame.Generators.StandardGenerators;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class HuntingHut extends StandardGenerator {

    public HuntingHut(IInventory inventory) {
        super(inventory,
                Map.of(ItemId.Wood, new BigInteger("1100"),
                        ItemId.Stone, new BigInteger("320"),
                        ItemId.Student, new BigInteger("3")),
                10,
                Map.of(ItemId.Beer, new BigInteger("1")),
                Map.of(ItemId.Meat, new BigInteger("12")),
                3);
    }
}
