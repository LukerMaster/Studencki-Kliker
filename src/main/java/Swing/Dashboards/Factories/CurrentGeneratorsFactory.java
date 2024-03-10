package Swing.Dashboards.Factories;

import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IWorld;
import ClickerGame.World.IWorldEventHandler;
import Swing.Dashboards.IDashboardFactory;
import Swing.Localization.IStringsProvider;

import javax.swing.*;
import java.awt.*;

import static Swing.Localization.StringId.Generators;

public class CurrentGeneratorsFactory implements IDashboardFactory {

    final IWorld world;
    final IWorldEventHandler eventHandler;
    final IStringsProvider stringsProvider;

    public CurrentGeneratorsFactory(IWorld generatorList, IWorldEventHandler eventHandler, IStringsProvider stringsProvider) {
        this.world = generatorList;
        this.eventHandler = eventHandler;
        this.stringsProvider = stringsProvider;
    }

    private void PresentGeneratorOnPanel(IGenerator generator, JPanel panel, GridLayout layout)
    {
        JPanel generatorPanel = new JPanel(new GridLayout(1, 2));
        JLabel generatorName = new JLabel(stringsProvider.GetNameForGenerator(generator));
        JLabel generatorDescription = new JLabel("<html>" + stringsProvider.GetGenerationDescription(generator.GetGenerationStrategy()) + "</html>");

        generatorPanel.add(generatorName);
        generatorPanel.add(generatorDescription);

        layout.setRows(layout.getRows() + 1);
        panel.add(generatorPanel);
    }

    @Override
    public JComponent CreateDashboard() {
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));

        JLabel titleLabel = new JLabel();
        titleLabel.setText(stringsProvider.GetStringFor(Generators));
        mainPanel.add(titleLabel);

        JPanel generatorsPanel = new JPanel();
        GridLayout layout = new GridLayout(1, 1);
        generatorsPanel.setLayout(layout);
        eventHandler.AddListener_OnBeforeAddGenerator(gen -> PresentGeneratorOnPanel(gen, generatorsPanel, layout));

        for (IGenerator generator : world.GetActiveGenerators()) {
            PresentGeneratorOnPanel(generator, generatorsPanel, layout);
        }

        mainPanel.add(generatorsPanel);
        return mainPanel;
    }
}
