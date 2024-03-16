package Swing.Dashboards.Factories;

import ClickerGame.Generators.Factories.IGeneratorFactory;
import ClickerGame.Generators.IGenerator;
import ClickerGame.Generators.IMadeOutOf;
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

    private static final int SCROLL_SPEED = 32;
    private final List<IGeneratorFactory> factories;
    private final IWorld world;
    private final IObservableItemsProvider observableItems;
    private final IStringsProvider stringsProvider;


    public GeneratorBuyMenuFactory(List<IGeneratorFactory> recipes,
                                   IWorld world,
                                   IObservableItemsProvider observableItems,
                                   IStringsProvider stringsProvider)
    {
        this.factories = recipes;
        this.world = world;
        this.observableItems = observableItems;
        this.stringsProvider = stringsProvider;
    }
    @Override
    public JComponent CreateDashboard() {

        JPanel allSchematicsPanel = new JPanel();
        allSchematicsPanel.setLayout(new BoxLayout(allSchematicsPanel, BoxLayout.Y_AXIS));
        for (IGeneratorFactory factory : factories)
        {
            IGenerator generatorToDescribe = factory.CreateGenerator();
            IMadeOutOf generatorMaterials = (IMadeOutOf) generatorToDescribe;

            JPanel singleSchematicPanel = new JPanel();
            singleSchematicPanel.setLayout(new GridLayout(1, 2));

            JPanel descriptionPanel = new JPanel();
            descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));

            JLabel nameLabel = new JLabel();
            nameLabel.setText(stringsProvider.GetNameForGenerator(generatorToDescribe));
            nameLabel.setFont(nameLabel.getFont().deriveFont(14f));
            nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JTextArea buildCostLabel = new JTextArea();
            buildCostLabel.setText("\n" + stringsProvider.GetStringFor(StringId.Build_cost) + ":\n" + stringsProvider.FormatItemsAsString(generatorMaterials.GetWhatItsMadeOutOf()));
            buildCostLabel.setEditable(false);
            buildCostLabel.setOpaque(true);
            buildCostLabel.setFont(new JLabel().getFont());

            JTextArea generationLabel = new JTextArea();
            generationLabel.setText("\n" + stringsProvider.GetGenerationDescription(generatorToDescribe.GetGenerationStrategy()));
            generationLabel.setEditable(false);
            generationLabel.setOpaque(true);
            generationLabel.setFont(new JLabel().getFont());

            JButton buyButton = new JButton();
            buyButton.setText(stringsProvider.GetStringFor(StringId.Build));
            buyButton.setEnabled(world.GetInventory().hasItems(generatorMaterials.GetWhatItsMadeOutOf()));

            for (ItemId itemId : ItemId.values())
            {
                if (generatorMaterials.GetWhatItsMadeOutOf().get(itemId) != null)
                    observableItems.addListener((id, amount) -> buyButton.setEnabled(world.GetInventory().hasItems(generatorMaterials.GetWhatItsMadeOutOf())));
            }
            buyButton.addActionListener(e ->
                    {
                        world.GetInventory().takeItems(generatorMaterials.GetWhatItsMadeOutOf());
                        world.AddNewGenerator(factory.CreateGenerator());
                    });


            descriptionPanel.add(nameLabel);
            descriptionPanel.add(buildCostLabel);
            descriptionPanel.add(generationLabel);

            singleSchematicPanel.add(descriptionPanel);
            singleSchematicPanel.add(buyButton);

            allSchematicsPanel.add(singleSchematicPanel);

            // Add spacer between buttons
            allSchematicsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }
        JScrollPane scrollPane = new JScrollPane(allSchematicsPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(SCROLL_SPEED);
        scrollPane.getVerticalScrollBar().setBlockIncrement((int)(SCROLL_SPEED * 1.5f));


        JPanel dashboard = new JPanel();
        dashboard.setLayout(new BoxLayout(dashboard, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel();
        titleLabel.setText(stringsProvider.GetStringFor(StringId.Build_menu));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        dashboard.add(titleLabel);
        dashboard.add(scrollPane);
        return dashboard;
    }
}
