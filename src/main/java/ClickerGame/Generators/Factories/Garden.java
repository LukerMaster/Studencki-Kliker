package ClickerGame.Generators.Factories;

import ClickerGame.Generators.IGenerator;
import ClickerGame.Generators.StandardGenerators.GeneratorBuilder.GeneratorBuilder;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class Garden implements IGeneratorFactory{
    final private IInventory inventory;

    public Garden(IInventory inventory) {this.inventory = inventory;}
    @Override
    public IGenerator CreateGenerator() {
        GeneratorBuilder builder = new GeneratorBuilder();
        return builder.setInventory(inventory)
                .setItemsSpawned(Map.of(ItemId.Hops, new BigInteger("3"), ItemId.Potato, new BigInteger("5")))
                .setMadeOutOf(Map.of(ItemId.Wood, new BigInteger("20"), ItemId.Stone, new BigInteger("20")))
                .setScrappingDivisor(6)
                .setSecondsBetweenSpawns(30)
                .build();
    }
}
