package ClickerGame.Generators.Components.InternalInventory;


import ClickerGame.ItemId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;
import java.util.function.Consumer;

public interface IHasInternalInventory {
    IInventory GetInventory();
}