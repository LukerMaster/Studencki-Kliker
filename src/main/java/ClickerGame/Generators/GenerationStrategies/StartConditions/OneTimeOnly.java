package ClickerGame.Generators.GenerationStrategies.StartConditions;

import java.io.Serializable;
import java.util.function.Supplier;

public class OneTimeOnly implements Supplier<Boolean>, Serializable {

    boolean alreadyStartedOnce = false;
    @Override
    public Boolean get() {
        boolean currentValue = alreadyStartedOnce;
        alreadyStartedOnce = true;
        return !currentValue;
    }
}
