package Swing.TopBar.CustomControls;

import Swing.TopBar.CustomControls.Mediator.IMediator;

import javax.accessibility.AccessibleContext;
import javax.swing.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MultiplierButton extends JButton implements ITunable, INotifiesViaMediator {
    private IMediator _mediator;
    private final Supplier<Float> getter;
    private final Consumer<Float> setter;
    private final float step;

    public MultiplierButton(Supplier<Float> getter, Consumer<Float> setter, float step) {
        this.getter = getter;
        this.setter = setter;
        this.step = step;
    }


    @Override
    public void SetMediator(IMediator mediator)
    {
        _mediator = mediator;
    }

    @Override
    public void Increase()
    {
        setter.accept(getter.get()+step);
        _mediator.Notify(this, "increase");
    }
    @Override
    public void Decrease()
    {
        setter.accept(getter.get()-step);
        _mediator.Notify(this, "decrease");
    }

    @Override
    public float GetValue() {
        return getter.get();
    }
}
