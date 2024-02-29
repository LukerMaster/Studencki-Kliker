package Swing;

import ClickerGame.Actions.ICustomUserAction;
import ClickerGame.Localization.IStringsProvider;
import ClickerGame.Localization.StringId;
import ClickerGame.World.IWorld;
import Core.IProgramWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingClickerWindow implements IProgramWindow {


    IWorld world;
    IStringsProvider stringsProvider;
    public SwingClickerWindow(IStringsProvider stringsProvider, IWorld world)
    {
        this.world = world;
        this.stringsProvider = stringsProvider;
    }

    private JPanel mainPanel;
    private JLabel actionsLabel;
    private JScrollPane actionsScrollPanel;
    private JPanel buttonPanel;
    private JPanel actionsDashboard;
    private JPanel resourcesDashboard;
    private JLabel resourcesLabel;
    private JPanel resourcesPanel;

    @Override
    public void Start() {

        mainPanel.setLayout(new GridLayout(3, 1));

        buttonPanel.setLayout(new GridLayout(world.GetAvailableActions().size(), 1));
        for (ICustomUserAction action : world.GetAvailableActions())
        {
            JButton button = new JButton();
            button.setText(stringsProvider.GetNameForAction(action.GetActionId()));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    action.execute();
                }
            });

            buttonPanel.add(button);
        }


        JFrame frame = new JFrame(stringsProvider.GetStringFor(StringId.Title));
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
