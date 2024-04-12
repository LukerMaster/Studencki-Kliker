package ClickerGame.StringPresenting;

import ClickerGame.Generators.IGenerator;

public class GeneratorToStringAdapter {

    public String toString(IGenerator generator) {
        return generator.getClass().toString() +
                " on finish strategy " +
                generator.GetGenerationStrategy().GetOnStart().toString();
    }
}
