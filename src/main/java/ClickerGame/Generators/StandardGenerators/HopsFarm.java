package ClickerGame.Generators.StandardGenerators;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class HopsFarm extends StandardGenerator {
    public HopsFarm(IInventory inventory) {
        super(inventory,
                Map.of(ItemId.Hops, new BigInteger("2"),
                        ItemId.Wood, new BigInteger("155"),
                        ItemId.Stone, new BigInteger("60"),
                        ItemId.Student, new BigInteger("1"))
                ,
                10,
                Map.of(ItemId.Beer, new BigInteger("1"),
                        ItemId.Meat, new BigInteger("1")),
                Map.of(ItemId.Hops, new BigInteger("9")),
                3);
    }
}
