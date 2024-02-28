package ClickerGame.Actions;

/**
 * Represents an action taken by the user to do something custom.
 */
public interface ICustomUserAction {

    CustomActionId GetActionId();

    void execute();
}
