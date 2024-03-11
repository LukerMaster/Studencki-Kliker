package Swing.Dashboards.Factories;

import ClickerGame.ItemId;
import ClickerGame.Localization.IStringsProvider;
import ClickerGame.Localization.StringId;
import ClickerGame.World.IObservableItemsProvider;
import Swing.Dashboards.IDashboardFactory;

import javax.swing.*;
import java.awt.*;

public class ResourcesDashboardFactory implements IDashboardFactory {


    public ResourcesDashboardFactory(IStringsProvider stringsProvider, IObservableItemsProvider inventory) {
        this.stringsProvider = stringsProvider;
        this.inventory = inventory;
    }

    final IStringsProvider stringsProvider;
    private final IObservableItemsProvider inventory;

    @Override
    public JComponent CreateDashboard() {
        JLabel label = new JLabel();
        label.setText(stringsProvider.GetStringFor(StringId.Your_Resources));

        JPanel resourcePanel = new JPanel();

        resourcePanel.setLayout(new GridLayout(ItemId.values().length, 2));
        for (ItemId id : ItemId.values())
        {
            resourcePanel.add(new JLabel(stringsProvider.GetNameForItem(id)));

            JLabel amountLabel = new JLabel();
            amountLabel.setText("0");
            inventory.addListener((itemId, amount) ->
            {
                if (itemId == id)
                    amountLabel.setText(amount.toString());
            });
            resourcePanel.add(amountLabel);
        }

        JPanel dashboard = new JPanel();
        dashboard.setLayout(new GridLayout(2, 1));
        dashboard.add(label);
        dashboard.add(resourcePanel);
        return dashboard;
    }
}
