package Tests;

import ClickerGame.Generators.*;
import ClickerGame.Generators.CustomGenerators.DemoGenerator;
import ClickerGame.Generators.CustomGenerators.HopsBush;
import ClickerGame.Generators.CustomGenerators.SmallTreeFarm;
import ClickerGame.Generators.CustomGenerators.StudentTrap;
import ClickerGame.Generators.StandardGenerators.*;
import ClickerGame.World.IInventory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class IsMadeOutOfTestCase {

    @Mock
    static IInventory inventory;

    @Mock
    static Random rng;

    public static List<IMadeOutOf[]> instancesToTest() {
        return Arrays.asList(
                new IMadeOutOf[]{ new Brewery(inventory) },
                new IMadeOutOf[]{ new DemoGenerator(inventory)},
                new IMadeOutOf[]{ new HopsBush(inventory)},
                new IMadeOutOf[]{ new HuntingHut(inventory)},
                new IMadeOutOf[]{ new Quarry(inventory)},
                new IMadeOutOf[]{ new SmallTreeFarm(inventory)},
                new IMadeOutOf[]{ new StudentTrap(rng, inventory)}
        );
    }

    @ParameterizedTest
    @MethodSource("instancesToTest")
    public void IsNotNegative(IMadeOutOf generator) {
        generator.GetWhatItsMadeOutOf().forEach((x, y) -> assertFalse(y.signum() < 0));
    }
}
