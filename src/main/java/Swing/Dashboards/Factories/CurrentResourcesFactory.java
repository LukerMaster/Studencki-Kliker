package Swing.Dashboards.Factories;

import ClickerGame.ItemId;
import ClickerGame.Localization.IStringsProvider;
import ClickerGame.Localization.StringId;
import ClickerGame.World.IObservableItemsProvider;
import Swing.IControlFactory;

import javax.swing.*;
import java.awt.*;

public class CurrentResourcesFactory implements IControlFactory {


    public CurrentResourcesFactory(IStringsProvider stringsProvider, IObservableItemsProvider inventory) {
        this.stringsProvider = stringsProvider;
        this.inventory = inventory;
    }

    final IStringsProvider stringsProvider;
    private final IObservableItemsProvider inventory;

    @Override
    public JComponent CreateControl() {

        JPanel resourcePanel = new JPanel();

        resourcePanel.setLayout(new GridLayout(ItemId.values().length, 2));
        for (ItemId id : ItemId.values())
        {
            JLabel nameLabel = new JLabel(stringsProvider.GetNameForItem(id));
            nameLabel.setFont(nameLabel.getFont().deriveFont(16f));

            JLabel amountLabel = new JLabel();
            amountLabel.setText(inventory.getCount(id).toString());
            inventory.addListener((itemId, amount) ->
            {
                if (itemId == id)
                    amountLabel.setText(amount.toString());
            });

            resourcePanel.add(nameLabel);
            resourcePanel.add(amountLabel);
        }

        JScrollPane scrollPane = new JScrollPane(resourcePanel);

        JPanel dashboard = new JPanel();
        dashboard.setLayout(new BoxLayout(dashboard, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel();
        titleLabel.setText(stringsProvider.GetStringFor(StringId.Your_Resources));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        dashboard.add(titleLabel);
        dashboard.add(scrollPane);
        return dashboard;
    }
}
