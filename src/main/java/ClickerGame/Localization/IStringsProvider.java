package ClickerGame.Localization;

import ClickerGame.Generators.GeneratorId;
import ClickerGame.ItemId;

/**
 * Interface used to make localization easier.
 * Anytime there is a need to add a string to a program, just use this interface.
 * It being abstracted allows for easier changes if implementation changes
 * in newer versions of Java.
 * (Keep in mind that such wrappers should be SMALL, otherwise it's reinventing the wheel).
 */
public interface IStringsProvider {
    String GetNameForItem(ItemId Id);
    String GetNameForGenerator(GeneratorId Id);

    String GetStringFor(StringId Id);
}
