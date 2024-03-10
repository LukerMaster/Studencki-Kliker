package Swing.Localization.GenerationPresenters;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import Swing.Localization.IStringsProvider;

public interface IGenerationPresentingStrategy {
    String GetFormattedRepresentation(String template, IGeneration generation, IStringsProvider provider);
}
