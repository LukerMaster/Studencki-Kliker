package ClickerGame.Actions;

import ClickerGame.Localization.StringId;

public interface IUserAction {

    StringId getInternalNameStringId();

    void execute();
}
