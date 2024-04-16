package Swing.TopBar.CustomControls;

import Swing.TopBar.CustomControls.Mediator.IMediator;

import javax.accessibility.AccessibleContext;
import javax.swing.*;

public class MultiplierButton extends JButton implements ITunable, INotifiesViaMediator {
    private IMediator _mediator;
    private float _value = 1;
    @Override
    public void SetMediator(IMediator mediator)
    {
        _mediator = mediator;
    }

    @Override
    public void Increase()
    {
        _value+=0.1f;
        _mediator.Notify(this, "increase");
    }
    @Override
    public void Decrease()
    {
        _value-=0.1f;
        if (_value < 0.1f)
            _value = 0.1f;
        _mediator.Notify(this, "decrease");
    }

    @Override
    public float GetValue() {
        return _value;
    }
}
