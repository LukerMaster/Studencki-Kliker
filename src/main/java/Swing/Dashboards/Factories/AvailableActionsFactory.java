package Swing.Dashboards.Factories;

import ClickerGame.Actions.ICustomUserAction;
import ClickerGame.ItemId;
import ClickerGame.Localization.IStringsProvider;
import ClickerGame.Localization.StringId;
import ClickerGame.World.IWorld;
import Swing.Dashboards.IDashboardFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AvailableActionsFactory implements IDashboardFactory {
    private IStringsProvider stringsProvider;

    public AvailableActionsFactory(IStringsProvider stringsProvider, IWorld world) {
        this.stringsProvider = stringsProvider;
        this.world = world;
    }

    private IWorld world;

    @Override
    public JComponent CreateDashboard() {
        JLabel label = new JLabel();
        label.setText(stringsProvider.GetStringFor(StringId.Actions));

        JPanel resourcePanel = new JPanel();

        resourcePanel.setLayout(new GridLayout(ItemId.values().length, 1));
        for (ICustomUserAction action : world.GetAvailableActions())
        {
            JButton button = new JButton(stringsProvider.GetNameForAction(action.GetActionId()));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    action.execute();
                }
            });

            resourcePanel.add(button);
        }

        JPanel dashboard = new JPanel();
        dashboard.setLayout(new GridLayout(2, 1));
        dashboard.add(label);
        dashboard.add(resourcePanel);
        return dashboard;
    }
}
