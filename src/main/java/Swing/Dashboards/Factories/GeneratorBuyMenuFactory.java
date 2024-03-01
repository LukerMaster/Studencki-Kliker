package Swing.Dashboards.Factories;

import ClickerGame.Generators.Templates.IGeneratorTemplate;
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

    private final List<IGeneratorTemplate> templates;
    private final IWorld world;
    private final IObservableItemsProvider observableItems;
    private final IStringsProvider stringsProvider;

    public GeneratorBuyMenuFactory(List<IGeneratorTemplate> templates,
                                   IWorld world,
                                   IObservableItemsProvider observableItems,
                                   IStringsProvider stringsProvider)
    {
        this.templates = templates;
        this.world = world;
        this.observableItems = observableItems;
        this.stringsProvider = stringsProvider;
    }
    @Override
    public JComponent CreateDashboard() {

        JPanel allSchematicsPanel = new JPanel(new GridLayout(templates.size(), 1));
        for (IGeneratorTemplate template : templates)
        {
            JPanel singleSchematicPanel = new JPanel();
            singleSchematicPanel.setLayout(new GridLayout(1, 2));
            JLabel label = new JLabel();
            label.setText(stringsProvider.GetStringFor(StringId.Build) + ": " + stringsProvider.GetNameForGenerator(template.GetGeneratorId()));

            JButton buyButton = new JButton();
            buyButton.setText(stringsProvider.GetStringFor(StringId.Build));
            buyButton.setEnabled(world.GetInventory().hasItems(template.GetCost()));
            for (ItemId itemId : ItemId.values())
            {
                if (template.GetCost().get(itemId) != null)
                    observableItems.addListener((id, amount) -> buyButton.setEnabled(world.GetInventory().hasItems(template.GetCost())));
            }
            buyButton.addActionListener(e ->
                    {
                        world.GetInventory().takeItems(template.GetCost());
                        world.GetActiveGenerators().add(template.GetGeneratorSupplier().get());
                    });

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
