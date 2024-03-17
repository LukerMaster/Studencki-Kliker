package Tests;

import ClickerGame.Generators.*;
import ClickerGame.World.IInventory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GeneratorTests {
    @Mock
    static IInventory inventory;

    @Mock
    static Random rng;
    public static List<IGenerator[]> instancesToTest() {
        return Arrays.asList(
                new IGenerator[]{ new Brewery(inventory) },
                new IGenerator[]{ new DemoGenerator(inventory)},
                new IGenerator[]{ new HopsBush(inventory)},
                new IGenerator[]{ new HuntingHut(inventory)},
                new IGenerator[]{ new Quarry(inventory)},
                new IGenerator[]{ new SmallTreeFarm(inventory)},
                new IGenerator[]{new StudentTrap(rng, inventory)}
        );
    }

    @ParameterizedTest
    @MethodSource("instancesToTest")
    public void GenerationStrategyNotNull(IGenerator generator) {
        assertNotNull(generator.GetGenerationStrategy());
    }
}
