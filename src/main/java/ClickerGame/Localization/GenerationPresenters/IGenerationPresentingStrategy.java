package ClickerGame.Localization.GenerationPresenters;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Localization.IStringsProvider;

public interface IGenerationPresentingStrategy {
    String GetFormattedRepresentation(String template, IGeneration generation, IStringsProvider provider);
}
