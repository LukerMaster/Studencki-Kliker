package Swing;

import ClickerGame.Localization.IStringsProvider;
import ClickerGame.Localization.StringId;
import Core.IProgramWindow;

import javax.swing.*;

public class SwingClickerWindow implements IProgramWindow {


    IStringsProvider stringsProvider;
    public SwingClickerWindow(IStringsProvider stringsProvider)
    {
        this.stringsProvider = stringsProvider;
    }

    private JPanel mainPanel;

    @Override
    public void Start() {
        JFrame frame = new JFrame(stringsProvider.GetStringFor(StringId.Title));
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
