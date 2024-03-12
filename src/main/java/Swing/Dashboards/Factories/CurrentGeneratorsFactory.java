package Swing.Dashboards.Factories;

import ClickerGame.Generators.GenerationStrategies.IPeriodicProgressingAction;
import ClickerGame.Generators.IGenerator;
import ClickerGame.World.IWorld;
import ClickerGame.World.IWorldEventHandler;
import Swing.Dashboards.IDashboardFactory;
import ClickerGame.Localization.IStringsProvider;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import static ClickerGame.Localization.StringId.ActiveGenerators;

public class CurrentGeneratorsFactory implements IDashboardFactory {

    private static final int SCROLL_SPEED = 32;
    final IWorld world;
    final IWorldEventHandler eventHandler;
    final IStringsProvider stringsProvider;

    public CurrentGeneratorsFactory(IWorld generatorList, IWorldEventHandler eventHandler, IStringsProvider stringsProvider) {
        this.world = generatorList;
        this.eventHandler = eventHandler;
        this.stringsProvider = stringsProvider;
    }

    private void PresentGeneratorOnPanel(IGenerator generator, JPanel panel)
    {

        JLabel generatorName = new JLabel(stringsProvider.GetNameForGenerator(generator));
        generatorName.setFont(generatorName.getFont().deriveFont(14f));
        generatorName.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextArea generatorDescription = new JTextArea(stringsProvider.GetGenerationDescription(generator.GetGenerationStrategy()));
        generatorDescription.setEditable(false);
        generatorDescription.setOpaque(true);
        generatorDescription.setFont(new JLabel().getFont());


        JPanel generatorPanel = new JPanel();
        generatorPanel.setLayout(new BoxLayout(generatorPanel, BoxLayout.Y_AXIS));

        generatorPanel.add(generatorName);
        generatorPanel.add(generatorDescription);

        if (Arrays.asList(generator.GetGenerationStrategy().getClass().getInterfaces()).contains(IPeriodicProgressingAction.class))
        {
            JProgressBar progressBar = new JProgressBar();
            IPeriodicProgressingAction strategy = (IPeriodicProgressingAction) generator.GetGenerationStrategy();
            strategy.AddOnProgressChangeListener(f -> progressBar.setValue((int) (f * 100)));

            generatorPanel.add(progressBar);
        }

        panel.add(generatorPanel);

        // Spacer
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.revalidate();
        panel.repaint();
    }

    @Override
    public JComponent CreateDashboard() {


        JPanel generatorsPanel = new JPanel();
        generatorsPanel.setLayout(new BoxLayout(generatorsPanel, BoxLayout.Y_AXIS));
        eventHandler.AddListener_OnBeforeAddGenerator(gen -> PresentGeneratorOnPanel(gen, generatorsPanel));

        for (IGenerator generator : world.GetActiveGenerators()) {
            PresentGeneratorOnPanel(generator, generatorsPanel);
        }

        JScrollPane scrollPane = new JScrollPane(generatorsPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(SCROLL_SPEED);
        scrollPane.getVerticalScrollBar().setBlockIncrement((int)(SCROLL_SPEED * 1.5f));


        JPanel dashboard = new JPanel();
        dashboard.setLayout(new BoxLayout(dashboard, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel();
        titleLabel.setText(stringsProvider.GetStringFor(ActiveGenerators));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        dashboard.add(titleLabel);
        dashboard.add(scrollPane);
        return dashboard;
    }
}
