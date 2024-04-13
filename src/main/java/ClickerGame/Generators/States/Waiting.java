package ClickerGame.Generators.States;

import java.io.Serializable;

public class Waiting implements IState, Serializable {
    @Override
    public String getName() {
        return "Waiting";
    }
}
