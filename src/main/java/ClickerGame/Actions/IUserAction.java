package ClickerGame.Actions;

import ClickerGame.Localization.StringId;

/**
 * Represents an action taken by the user to do pretty much anything in the world.
 */
public interface IUserAction {

    StringId getInternalNameStringId();

    void execute();
}
