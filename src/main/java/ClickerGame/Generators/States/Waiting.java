package ClickerGame.Generators.States;

import java.util.function.Supplier;

public class Waiting implements IState {

    private final Supplier<Boolean> requirement;
    private Runnable OnFinish;

    public Waiting(Supplier<Boolean> requirement)
    {
        this.requirement = requirement;
    }

    @Override
    public String getName() {
        return "Waiting";
    }

    @Override
    public void Progress(float deltaTime) {
        if (requirement.get())
        {
            OnFinish.run();
        }
    }

    @Override
    public void SetOnFinish(Runnable function) {
        this.OnFinish = function;
    }
}
