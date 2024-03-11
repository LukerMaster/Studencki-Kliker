package ClickerGame.Localization.GenerationPresenters;

import ClickerGame.Generators.GenerationStrategies.IChanceBasedSpawning;
import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.IPeriodicSpawning;
import ClickerGame.Localization.IStringsProvider;
import ClickerGame.Localization.StringId;

import java.util.Arrays;

public class GenerationPresentingStrategy implements IGenerationPresentingStrategy {

    @Override
    public String GetFormattedRepresentation(String template, IGeneration generation, IStringsProvider provider) {

        if (GenerationIs(generation, IPeriodicSpawning.class))
        {
            IPeriodicSpawning spawning = ((IPeriodicSpawning) generation);
            return String.format(template,
                    spawning.GetItemsTaken().isEmpty() ? provider.GetStringFor(StringId.Nothing) : provider.FormatItemsAsString(spawning.GetItemsTaken()),
                    provider.FormatItemsAsString(spawning.GetItemsSpawned()),
                    spawning.GetSecondsBetweenSpawns());
        }
        if (GenerationIs(generation, IChanceBasedSpawning.class))
        {
            IChanceBasedSpawning spawning = ((IChanceBasedSpawning) generation);
            return String.format(template,
                    spawning.GetChanceOfSpawning() * 100,
                    spawning.GetItemsTaken().isEmpty() ? provider.GetStringFor(StringId.Nothing) : provider.FormatItemsAsString(spawning.GetItemsTaken()),
                    provider.FormatItemsAsString(spawning.GetItemsSpawned()),
                    spawning.GetSecondsBetweenSpawns());
        }
        throw new IllegalArgumentException("Unknown generation class");
    }

    private <T> boolean GenerationIs(IGeneration generation, Class<T> c)
    {
        return Arrays.asList(generation.getClass().getInterfaces()).contains(c);
    }
}
