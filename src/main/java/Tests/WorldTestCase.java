package Tests;

import ClickerGame.Actions.ICustomUserAction;
import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IInventory;
import ClickerGame.World.IWorld;
import ClickerGame.World.World;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

// World tests using mocks of its dependencies
@ExtendWith(MockitoExtension.class)
public class WorldTestCase {


    @Mock
    static IInventory inventory;

    @Mock
    static List<ICustomUserAction> customUserActionList;

    @Mock
    static IGenerator dummyGenerator;

    @Mock
    static Random random;

    public static IWorld[] GetWorld()
    {
        return new World[]{new World(inventory, customUserActionList, random)};
    }
    @ParameterizedTest
    @MethodSource("GetWorld")
    public void AddGenerator(IWorld world) {

        world.AddNewGenerator(dummyGenerator);

        assertEquals(1, world.GetActiveGenerators().size());
        assertEquals(dummyGenerator, world.GetActiveGenerators().peek());
    }

    @ParameterizedTest
    @MethodSource("GetWorld")
    public void AddAndRemoveGenerator(IWorld world) {
        world.AddNewGenerator(dummyGenerator);
        world.RemoveGenerator(dummyGenerator);
        assertEquals(0, world.GetActiveGenerators().size());
    }

    @ParameterizedTest
    @MethodSource("GetWorld")
    public void AssertConstructorValues(IWorld world)
    {
        assertEquals(inventory, world.GetInventory());
        assertEquals(customUserActionList, world.GetAvailableActions());
        assertEquals(random, world.GetRng());
    }
}
