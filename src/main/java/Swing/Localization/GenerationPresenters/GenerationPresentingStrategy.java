package Swing.Localization.GenerationPresenters;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.IPeriodicSpawning;
import Swing.Localization.IStringsProvider;
import Swing.Localization.StringId;

import java.util.Arrays;

public class GenerationPresentingStrategy implements IGenerationPresentingStrategy {

    @Override
    public String GetFormattedRepresentation(String template, IGeneration generation, IStringsProvider provider) {

        if (Arrays.stream(generation.getClass().getInterfaces()).anyMatch(x -> x.equals(IPeriodicSpawning.class)))
        {
            IPeriodicSpawning spawning = ((IPeriodicSpawning) generation);
            return String.format(template,
                    spawning.GetItemsTaken().isEmpty() ? provider.GetStringFor(StringId.Nothing) : provider.FormatItemsAsString(spawning.GetItemsTaken()),
                    provider.FormatItemsAsString(spawning.GetItemsSpawned()),
                    spawning.GetSecondsBetweenSpawns());
        }
        throw new IllegalArgumentException("Unknown generation class");
    }
}
