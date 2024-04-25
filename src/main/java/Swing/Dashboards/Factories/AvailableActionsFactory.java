package Swing.Dashboards.Factories;

import ClickerGame.Actions.CustomActionIterator;
import ClickerGame.Actions.ICustomUserAction;
import ClickerGame.Actions.Iterator;
import ClickerGame.World.IObservableItemsProvider;
import ClickerGame.Localization.IStringsProvider;
import ClickerGame.Localization.StringId;
import Swing.IControlFactory;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AvailableActionsFactory implements IControlFactory {
    private final IStringsProvider stringsProvider;

    public AvailableActionsFactory(IStringsProvider stringsProvider, List<ICustomUserAction> actionList, IObservableItemsProvider inventory) {
        this.stringsProvider = stringsProvider;
        this.actionList = actionList;
        this.inventory = inventory;
    }

    private final List<ICustomUserAction> actionList;
    final IObservableItemsProvider inventory;

    @Override
    public JComponent CreateControl() {


        JPanel resourcePanel = new JPanel();

        resourcePanel.setLayout(new BoxLayout(resourcePanel, BoxLayout.Y_AXIS));
        Iterator<ICustomUserAction> iterator = new CustomActionIterator(actionList);

        while (iterator.hasNext())
        {
            ICustomUserAction action = iterator.next();
            JButton button = new JButton(stringsProvider.GetNameForAction(action));
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getPreferredSize().height));
            button.addActionListener(e -> action.execute());
            button.setEnabled(action.canExecute());
            button.setToolTipText(stringsProvider.GetTooltipForAction(action));
            inventory.addListener((id, count) -> button.setEnabled(action.canExecute()));
            resourcePanel.add(button);

        }
        JScrollPane scrollPane = new JScrollPane(resourcePanel);

        JPanel dashboard = new JPanel();
        dashboard.setLayout(new BoxLayout(dashboard, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel();
        titleLabel.setText(stringsProvider.GetStringFor(StringId.Actions));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        dashboard.add(titleLabel);
        dashboard.add(scrollPane);
        return dashboard;
    }
}
