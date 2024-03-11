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
import java.util.List;

public class GeneratorBuyMenuFactory implements IDashboardFactory {

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

        JPanel allSchematicsPanel = new JPanel(new GridLayout(recipes.size(), 1));
        for (IBuildRecipe recipe : recipes)
        {
            IGenerator generatorToDescribe = recipe.CreateGenerator();

            JPanel singleSchematicPanel = new JPanel();
            singleSchematicPanel.setLayout(new GridLayout(1, 2));

            JPanel descriptionPanel = new JPanel(new GridLayout(3, 1));

            JLabel nameLabel = new JLabel();
            nameLabel.setText(stringsProvider.GetStringFor(StringId.Build) + ": " + stringsProvider.GetNameForGenerator(generatorToDescribe));
            descriptionPanel.add(nameLabel);

            JLabel buildCostLabel = new JLabel();
            buildCostLabel.setText("<html><br/>" + stringsProvider.GetStringFor(StringId.Build_cost) + ":<br/>" + stringsProvider.FormatItemsAsString(recipe.GetBuildCost()) + "</html>");
            descriptionPanel.add(buildCostLabel);

            JLabel generationLabel = new JLabel();
            generationLabel.setText("<html><br/>" + stringsProvider.GetGenerationDescription(generatorToDescribe.GetGenerationStrategy()) + "</html>");
            descriptionPanel.add(generationLabel);

            singleSchematicPanel.add(descriptionPanel);

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
