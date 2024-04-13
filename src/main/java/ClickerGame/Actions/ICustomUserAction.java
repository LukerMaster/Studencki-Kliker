package ClickerGame.Actions;

/**
 * Represents an action taken by the user to do something custom.
 */
public interface ICustomUserAction {
    void execute();
    boolean canExecute();
    default String getName()
    {
        return this.getClass().getSimpleName();
    }
}
