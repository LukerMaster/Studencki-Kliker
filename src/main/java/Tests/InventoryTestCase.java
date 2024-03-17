package Tests;


import ClickerGame.ItemId;
import ClickerGame.World.IInventory;
import ClickerGame.World.Inventory;
import Swing.ObservableInventory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class InventoryTestCase {

    public static List<IInventory[]> instancesToTest() {
        return Arrays.asList(
                new IInventory[]{new Inventory()},
                new IInventory[]{new ObservableInventory(new Inventory())}
        );
    }

    @ParameterizedTest
    @DisplayName("Add Items - Int")
    @MethodSource("instancesToTest")
    public void AddItems_Int(IInventory inventory) {
        inventory.addItems(ItemId.Wood, 10);
        assertEquals(new BigInteger("10"), inventory.getCount(ItemId.Wood));
    }

    @ParameterizedTest
    @DisplayName("Add and Remove Items - Int")
    @MethodSource("instancesToTest")
    public void AddAndRemoveItems_Int(IInventory inventory) {
        inventory.addItems(ItemId.Wood, 10);
        inventory.takeItems(ItemId.Wood, 5);
        assertEquals(new BigInteger("5"), inventory.getCount(ItemId.Wood));
    }

    @ParameterizedTest
    @DisplayName("Add Items - Map")
    @MethodSource("instancesToTest")
    public void AddItems_Map(IInventory inventory) {
        Map<ItemId, BigInteger> items = new java.util.HashMap<>();
        items.put(ItemId.Wood, new BigInteger("5"));
        inventory.addItems(items);
        assertEquals(new BigInteger("5"), inventory.getCount(ItemId.Wood));
    }

    @ParameterizedTest
    @DisplayName("Add and Remove Items - Map")
    @MethodSource("instancesToTest")
    public void AddAndRemoveItems_Map(IInventory inventory) {
        Map<ItemId, BigInteger> items = new java.util.HashMap<>();
        items.put(ItemId.Wood, new BigInteger("5"));
        inventory.addItems(items);
        inventory.takeItems(items);
        assertEquals(new BigInteger("0"), inventory.getCount(ItemId.Wood));
    }

    @ParameterizedTest
    @DisplayName("Has Items - Map")
    @MethodSource("instancesToTest")
    public void HasItems_Map(IInventory inventory) {
        Map<ItemId, BigInteger> items = new java.util.HashMap<>();
        items.put(ItemId.Wood, new BigInteger("5"));
        inventory.addItems(items);
        assertTrue(inventory.hasItems(items));
    }

    @ParameterizedTest
    @DisplayName("Has Items - Int")
    @MethodSource("instancesToTest")
    public void HasItems_Int(IInventory inventory) {
        inventory.addItems(ItemId.Wood, 5);
        assertTrue(inventory.hasItems(ItemId.Wood, 5));
    }
}
