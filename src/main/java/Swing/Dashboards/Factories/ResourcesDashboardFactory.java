package Swing.Dashboards.Factories;

import ClickerGame.ItemId;
import ClickerGame.Localization.IStringsProvider;
import ClickerGame.Localization.StringId;
import ClickerGame.World.IWorld;
import Swing.Dashboards.IDashboardFactory;

import javax.swing.*;
import java.awt.*;

public class ResourcesDashboardFactory implements IDashboardFactory {


    public ResourcesDashboardFactory(IStringsProvider stringsProvider, IWorld world) {
        this.stringsProvider = stringsProvider;
        this.world = world;
    }

    IStringsProvider stringsProvider;
    private final IWorld world;

    @Override
    public JComponent CreateDashboard() {
        JLabel label = new JLabel();
        label.setText(stringsProvider.GetStringFor(StringId.Your_Resources));

        JPanel resourcePanel = new JPanel();

        resourcePanel.setLayout(new GridLayout(ItemId.values().length, 2));
        for (ItemId id : ItemId.values())
        {
            resourcePanel.add(new JLabel(stringsProvider.GetNameForItem(id)));
            resourcePanel.add(new JLabel("0"));
        }

        JPanel dashboard = new JPanel();
        dashboard.setLayout(new GridLayout(2, 1));
        dashboard.add(label);
        dashboard.add(resourcePanel);
        return dashboard;
    }
}
