package Swing.Dashboards.Factories;

import ClickerGame.Actions.ICustomUserAction;
import ClickerGame.ItemId;
import ClickerGame.World.IInventory;
import ClickerGame.World.IObservableItemsProvider;
import Swing.Localization.IStringsProvider;
import Swing.Localization.StringId;
import Swing.Dashboards.IDashboardFactory;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AvailableActionsFactory implements IDashboardFactory {
    private final IStringsProvider stringsProvider;

    public AvailableActionsFactory(IStringsProvider stringsProvider, List<ICustomUserAction> actionList, IObservableItemsProvider inventory) {
        this.stringsProvider = stringsProvider;
        this.actionList = actionList;
        this.inventory = inventory;
    }

    private final List<ICustomUserAction> actionList;
    final IObservableItemsProvider inventory;

    @Override
    public JComponent CreateDashboard() {
        JLabel label = new JLabel();
        label.setText(stringsProvider.GetStringFor(StringId.Actions));

        JPanel resourcePanel = new JPanel();

        resourcePanel.setLayout(new GridLayout(ItemId.values().length, 1));
        for (ICustomUserAction action : actionList)
        {
            JButton button = new JButton(stringsProvider.GetNameForAction(action));
            button.addActionListener(e -> action.execute());
            button.setEnabled(action.canExecute());

            inventory.addListener((id, count) -> {button.setEnabled(action.canExecute());});


            resourcePanel.add(button);
        }

        JPanel dashboard = new JPanel();
        dashboard.setLayout(new GridLayout(2, 1));
        dashboard.add(label);
        dashboard.add(resourcePanel);
        return dashboard;
    }
}
