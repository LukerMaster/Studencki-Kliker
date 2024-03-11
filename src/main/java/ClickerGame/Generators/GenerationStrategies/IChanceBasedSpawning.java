package ClickerGame.Generators.GenerationStrategies;

import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

public interface IChanceBasedSpawning extends IPeriodicSpawning {
    float GetChanceOfSpawning();
}
