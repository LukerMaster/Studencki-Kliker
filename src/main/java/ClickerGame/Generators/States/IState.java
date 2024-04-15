package ClickerGame.Generators.States;

import java.io.Serializable;

public interface IState extends Serializable {
    String getName();
    void Progress(float deltaTime);
    void SetOnFinish(Runnable function);
}
