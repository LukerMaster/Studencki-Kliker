package ClickerGame.Actions;

import java.io.Serializable;

/**
 * Represents an action taken by the user to do something custom.
 */
public interface ICustomUserAction {
    void execute();
    boolean canExecute();
    void setPowerMultiplier(float value);
    default String getName()
    {
        return this.getClass().getSimpleName();
    }
}
