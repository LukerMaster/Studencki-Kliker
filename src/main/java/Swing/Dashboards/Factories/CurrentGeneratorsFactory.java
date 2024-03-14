package Swing.Dashboards.Factories;

import ClickerGame.Generators.GenerationStrategies.IPeriodicProgressingAction;
import ClickerGame.Generators.IGenerator;
import ClickerGame.Generators.Scraping.IScrappable;
import ClickerGame.World.IWorld;
import ClickerGame.World.IWorldEventHandler;
import Swing.Dashboards.IDashboardFactory;
import ClickerGame.Localization.IStringsProvider;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static ClickerGame.Localization.StringId.ActiveGenerators;

public class CurrentGeneratorsFactory implements IDashboardFactory {

    private static final int SCROLL_SPEED = 32;
    final IWorld world;
    final IWorldEventHandler eventHandler;
    final IStringsProvider stringsProvider;

    JPanel generatorsPanel;

    Map<IGenerator, JPanel> generatorUIs = new HashMap<>();

    public CurrentGeneratorsFactory(IWorld generatorList, IWorldEventHandler eventHandler, IStringsProvider stringsProvider) {
        this.world = generatorList;
        this.eventHandler = eventHandler;
        this.stringsProvider = stringsProvider;
    }

    private JPanel CreateGeneratorUI(IGenerator generator)
    {

        JLabel name = new JLabel(stringsProvider.GetNameForGenerator(generator));
        name.setFont(name.getFont().deriveFont(14f));
        name.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextArea description = new JTextArea(stringsProvider.GetGenerationDescription(generator.GetGenerationStrategy()));
        description.setEditable(false);
        description.setOpaque(true);
        description.setFont(new JLabel().getFont());

        JPanel mainArea = new JPanel();
        mainArea.setLayout(new BoxLayout(mainArea, BoxLayout.X_AXIS));

        mainArea.add(description);

        if (generator instanceof IScrappable)
        {
            JButton scrapButton = new JButton();
            scrapButton.setText(stringsProvider.GetNameForScrappingType(((IScrappable) generator).GetScrappingType()));
            scrapButton.addActionListener(b -> {
                world.GetInventory().addItems(((IScrappable) generator).GetScrapValue());
                world.RemoveGenerator(generator);
            });

            mainArea.add(scrapButton);
        }

        JPanel generatorPanel = new JPanel();
        generatorPanel.setLayout(new BoxLayout(generatorPanel, BoxLayout.Y_AXIS));

        generatorPanel.add(name);
        generatorPanel.add(mainArea);

        if (generator.GetGenerationStrategy() instanceof IPeriodicProgressingAction strategy)
        {
            JProgressBar progressBar = new JProgressBar();
            strategy.AddOnProgressChangeListener(f -> progressBar.setValue((int) (f * 100)));

            generatorPanel.add(progressBar);
        }
        generatorPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        return generatorPanel;
    }

    private void PresentOnGeneratorPanel(JPanel generatorUI)
    {
        generatorsPanel.add(generatorUI);
        generatorsPanel.revalidate();
        generatorsPanel.repaint();
    }

    private void RefreshView()
    {
        generatorsPanel.revalidate();
        generatorsPanel.repaint();
    }

    @Override
    public JComponent CreateDashboard() {

        generatorsPanel = new JPanel();
        generatorsPanel.setLayout(new BoxLayout(generatorsPanel, BoxLayout.Y_AXIS));
        eventHandler.AddListener_OnBeforeAddGenerator(gen -> {
            JPanel UI = CreateGeneratorUI(gen);
            PresentOnGeneratorPanel(UI);
            RefreshView();
            generatorUIs.put(gen, UI);
        });

        eventHandler.AddListener_OnAfterRemoveGenerator(gen -> {
            generatorsPanel.remove(generatorUIs.get(gen));
            generatorUIs.remove(gen);
            RefreshView();
        });

        for (IGenerator generator : world.GetActiveGenerators()) {
            CreateGeneratorUI(generator);
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
