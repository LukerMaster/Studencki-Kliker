package Swing;

import ClickerGame.Localization.IStringsProvider;
import ClickerGame.Localization.StringId;
import Core.IGameLoop;
import Core.IProgramWindow;
import Swing.Dashboards.IDashboardFactory;
import org.apache.commons.lang3.time.StopWatch;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ClickerWindow implements IProgramWindow {


    private final List<IDashboardFactory> dashboardFactories;
    private final IStringsProvider stringsProvider;
    private final StopWatch stopwatch = new StopWatch();
    private final IGameLoop gameLoop;

    public ClickerWindow(List<IDashboardFactory> dashboardFactories, IStringsProvider stringsProvider, IGameLoop gameLoop) {
        this.dashboardFactories = dashboardFactories;
        this.stringsProvider = stringsProvider;
        this.gameLoop = gameLoop;
    }

    private final JPanel mainPanel = new JPanel();

    @Override
    public void Start() {

        mainPanel.setLayout(new GridLayout());
        for (IDashboardFactory factory : dashboardFactories)
            mainPanel.add(factory.CreateDashboard());

        JFrame frame = new JFrame(stringsProvider.GetStringFor(StringId.Title));
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        stopwatch.start();
        while (true) {
            System.nanoTime();
            if (stopwatch.getTime() > 0.1f)
            {
                gameLoop.Update(stopwatch.getTime() / 1000.0f);
                stopwatch.reset();
                stopwatch.start();
            }

        }
    }
}
