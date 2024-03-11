package ClickerGame.Localization;

import ClickerGame.Actions.ICustomUserAction;
import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.Map;

/**
 * Interface used to make localization easier.
 * Anytime there is a need to add a string to a program, just use this interface.
 * It being abstracted allows for easier changes if implementation changes
 * in newer versions of Java.
 * (Keep in mind that such wrappers should be SMALL, otherwise it's reinventing the wheel).
 *
 */
// This - in fact - Implements a facade design pattern for ResourceBundle.
public interface IStringsProvider {
    String GetNameForItem(ItemId Id);
    String GetNameForAction(ICustomUserAction Action);
    String GetNameForGenerator(IGenerator Generator);
    String GetGenerationDescription(IGeneration Id);
    String FormatItemsAsString(Map<ItemId, BigInteger> cost);
    String GetStringFor(StringId Id);
}
