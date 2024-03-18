package ClickerGame.Generators.StandardGenerators;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class Mine extends StandardGenerator {
    public Mine(IInventory inventory) {
        super(inventory,
                Map.of(ItemId.Stone, new BigInteger("550"),
                        ItemId.Wood, new BigInteger("2200"),
                        ItemId.Student, new BigInteger("10")),
                24,
                Map.of(ItemId.Wood, new BigInteger("40"),
                        ItemId.Meat, new BigInteger("20"),
                        ItemId.Beer, new BigInteger("10")),
                Map.of(ItemId.Metal, new BigInteger("4")),
                3);
    }
}
