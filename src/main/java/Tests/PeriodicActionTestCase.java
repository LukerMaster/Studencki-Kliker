package Tests;

import ClickerGame.Generators.GenerationStrategies.PeriodicAction;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

// This is the only actually somewhat complicated function in the program.
// so it has dedicated test suite.
public class PeriodicActionTestCase {

    @Mock Runnable OnStart;

    @Mock Runnable OnFinish;

    @Mock
    Supplier<Boolean> Requirement;

    @Test
    public void AssertConstructorValues() {
        PeriodicAction action = new PeriodicAction(1, Requirement, OnStart, OnFinish);
        assertEquals(1, action.GetWorkTime());
        assertEquals(OnStart, action.GetOnStart());
        assertEquals(OnFinish, action.GetOnFinish());
        assertEquals(Requirement, action.GetRequirement());
    }
}
