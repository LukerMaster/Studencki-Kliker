package Swing.Dashboards.Factories;

import ClickerGame.Generators.Schemes.IGeneratorSchematic;
import ClickerGame.ItemId;
import ClickerGame.Localization.IStringsProvider;
import ClickerGame.Localization.StringId;
import ClickerGame.World.IObservableItemsProvider;
import ClickerGame.World.IWorld;
import Swing.Dashboards.IDashboardFactory;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GeneratorBuyMenuFactory implements IDashboardFactory {

    private final List<IGeneratorSchematic> schematics;
    private final IWorld world;
    private final IObservableItemsProvider observableItems;
    private final IStringsProvider stringsProvider;

    public GeneratorBuyMenuFactory(List<IGeneratorSchematic> schematics,
                                   IWorld world,
                                   IObservableItemsProvider observableItems,
                                   IStringsProvider stringsProvider)
    {
        this.schematics = schematics;
        this.world = world;
        this.observableItems = observableItems;
        this.stringsProvider = stringsProvider;
    }
    @Override
    public JComponent CreateDashboard() {

        JPanel allSchematicsPanel = new JPanel(new GridLayout(schematics.size(), 1));
        for (IGeneratorSchematic schematic : schematics)
        {
            JPanel singleSchematicPanel = new JPanel();
            singleSchematicPanel.setLayout(new GridLayout(1, 2));
            JLabel label = new JLabel();
            label.setText(stringsProvider.GetStringFor(StringId.Build) + ": " + stringsProvider.GetNameForGenerator(schematic.getGeneratorId()));

            JButton buyButton = new JButton();
            buyButton.setText(stringsProvider.GetStringFor(StringId.Build));
            buyButton.setEnabled(world.GetInventory().hasItems(schematic.getCost()));
            for (ItemId itemId : ItemId.values())
            {
                if (schematic.getCost().get(itemId) != null)
                    observableItems.addListener((id, amount) -> buyButton.setEnabled(world.GetInventory().hasItems(schematic.getCost())));
            }
            buyButton.addActionListener(e -> world.GetActiveGenerators().add(schematic.buyGenerator(world)));

            singleSchematicPanel.add(label);
            singleSchematicPanel.add(buyButton);
            allSchematicsPanel.add(singleSchematicPanel);
        }
        JLabel title = new JLabel();
        title.setText(stringsProvider.GetStringFor(StringId.Resource_generation));

        JPanel dashboard = new JPanel();
        dashboard.setLayout(new GridLayout(2, 1));

        dashboard.add(title);
        dashboard.add(allSchematicsPanel);
        return dashboard;
    }
}
