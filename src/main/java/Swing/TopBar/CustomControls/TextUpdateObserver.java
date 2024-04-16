package Swing.TopBar.CustomControls;

import Swing.TopBar.CustomControls.ITunable;

import javax.swing.*;

public class TextUpdateObserver<T extends JButton & ITunable> {

    final T button1;
    final T button2;
    private final String defaultText1;
    private final String defaultText2;

    public TextUpdateObserver(T button1, T button2, String defaultText1, String defaultText2) {
        this.button1 = button1;
        this.button2 = button2;
        this.defaultText1 = defaultText1;
        this.defaultText2 = defaultText2;

        this.button1.addActionListener(b -> UpdateTexts());
        this.button2.addActionListener(b -> UpdateTexts());
    }


    public void UpdateTexts() {
        button1.setText(defaultText1 + ": " + String.format("%.1f", button1.GetValue()) + "x" );
        button2.setText(defaultText2 + ": " + String.format("%.1f",button2.GetValue()) + "x" );
    }
}
