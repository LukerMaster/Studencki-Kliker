package ClickerGame.Generators.States;

import java.io.Serializable;

public class Running implements IState, Serializable {
    @Override
    public String getName()
    {
        return "Running";
    }
}
