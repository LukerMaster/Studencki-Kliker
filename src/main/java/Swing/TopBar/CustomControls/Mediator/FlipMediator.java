package Swing.TopBar.CustomControls.Mediator;

import Swing.TopBar.CustomControls.INotifiesViaMediator;
import Swing.TopBar.CustomControls.ITunable;

import java.util.Objects;

public class FlipMediator<T extends ITunable & INotifiesViaMediator> implements IMediator {

    T _button1;
    T _button2;

    public FlipMediator(T button1, T button2)
    {
        this._button1 = button1;
        _button1.SetMediator(this);
        this._button2 = button2;
        _button2.SetMediator(this);
    }

    @Override
    public void Notify(Object sender, String args) {

        T buttonToRevert = _button1;
        if (sender == _button1)
            buttonToRevert = _button2;

        if (Objects.equals(args, "increase"))
        {
            buttonToRevert.Decrease();
        }
    }
}
