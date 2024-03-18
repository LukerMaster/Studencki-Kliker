package ClickerGame.Generators.StandardGenerators;

import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class PotatoFarm extends StandardGenerator {
    public PotatoFarm(IInventory inventory) {
        super(inventory,
                Map.of(ItemId.Metal, new BigInteger("12"),
                        ItemId.Wood, new BigInteger("7200"),
                        ItemId.Stone, new BigInteger("2200"),
                        ItemId.Student, new BigInteger("1")),
                32,
                Map.of(ItemId.Vodka, new BigInteger("1"),
                        ItemId.Meat, new BigInteger("2"),
                        ItemId.Beer, new BigInteger("2")),
                Map.of(ItemId.Potato, new BigInteger("160")),
                3);
    }
}
