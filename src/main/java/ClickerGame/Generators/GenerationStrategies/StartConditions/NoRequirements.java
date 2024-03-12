package ClickerGame.Generators.GenerationStrategies.StartConditions;

import java.io.Serializable;
import java.util.function.Supplier;

public class NoRequirements implements Supplier<Boolean>, Serializable {
    @Override
    public Boolean get() {
        return true;
    }
}
