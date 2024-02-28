package ClickerGame.Actions;

import ClickerGame.Localization.StringId;

/**
 * Represents an action taken by the user to do something custom.
 */
public interface ICustomUserAction {

    StringId getInternalNameStringId();

    void execute();
}
