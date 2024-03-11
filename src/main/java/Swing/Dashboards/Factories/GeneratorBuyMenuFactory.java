package Swing.Dashboards.Factories;

import ClickerGame.Generators.BuildRecipes.IBuildRecipe;
import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;
import ClickerGame.Localization.IStringsProvider;
import ClickerGame.Localization.StringId;
import ClickerGame.World.IObservableItemsProvider;
import ClickerGame.World.IWorld;
import Swing.Dashboards.IDashboardFactory;

import javax.swing.*;
import java.awt.*;
import java.util.BitSet;
import java.util.List;

public class GeneratorBuyMenuFactory implements IDashboardFactory {

    private static final int SCROLL_SPEED = 32;
    private final List<IBuildRecipe> recipes;
    private final IWorld world;
    private final IObservableItemsProvider observableItems;
    private final IStringsProvider stringsProvider;


    public GeneratorBuyMenuFactory(List<IBuildRecipe> recipes,
                                   IWorld world,
                                   IObservableItemsProvider observableItems,
                                   IStringsProvider stringsProvider)
    {
        this.recipes = recipes;
        this.world = world;
        this.observableItems = observableItems;
        this.stringsProvider = stringsProvider;
    }
    @Override
    public JComponent CreateDashboard() {

        JPanel allSchematicsPanel = new JPanel();
        allSchematicsPanel.setLayout(new BoxLayout(allSchematicsPanel, BoxLayout.Y_AXIS));
        for (IBuildRecipe recipe : recipes)
        {
            IGenerator generatorToDescribe = recipe.CreateGenerator();

            JPanel singleSchematicPanel = new JPanel();
            singleSchematicPanel.setLayout(new GridLayout(1, 2));

            JPanel descriptionPanel = new JPanel();
            descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));

            JLabel nameLabel = new JLabel();
            nameLabel.setText(stringsProvider.GetNameForGenerator(generatorToDescribe));
            nameLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, nameLabel.getPreferredSize().height));
            nameLabel.setFont(nameLabel.getFont().deriveFont(14f));

            JLabel buildCostLabel = new JLabel();
            buildCostLabel.setText("<html><br/>" + stringsProvider.GetStringFor(StringId.Build_cost) + ":<br/>" + stringsProvider.FormatItemsAsString(recipe.GetBuildCost()) + "</html>");
            buildCostLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, buildCostLabel.getPreferredSize().height));

            JLabel generationLabel = new JLabel();
            generationLabel.setText("<html><br/>" + stringsProvider.GetGenerationDescription(generatorToDescribe.GetGenerationStrategy()) + "</html>");
            generationLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, generationLabel.getPreferredSize().height));

            JButton buyButton = new JButton();
            buyButton.setText(stringsProvider.GetStringFor(StringId.Build));
            buyButton.setEnabled(world.GetInventory().hasItems(recipe.GetBuildCost()));

            for (ItemId itemId : ItemId.values())
            {
                if (recipe.GetBuildCost().get(itemId) != null)
                    observableItems.addListener((id, amount) -> buyButton.setEnabled(world.GetInventory().hasItems(recipe.GetBuildCost())));
            }
            buyButton.addActionListener(e ->
                    {
                        world.GetInventory().takeItems(recipe.GetBuildCost());
                        world.AddNewGenerator(recipe.CreateGenerator());
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
        titleLabel.setText(stringsProvider.GetStringFor(StringId.Resource_generation));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        dashboard.add(titleLabel);
        dashboard.add(scrollPane);
        return dashboard;
    }
}
