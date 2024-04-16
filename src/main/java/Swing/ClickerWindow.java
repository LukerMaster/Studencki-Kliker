package Swing;

import ClickerGame.Localization.IStringsProvider;
import ClickerGame.Localization.StringId;
import Core.IGameLoop;
import Core.IProgramWindow;
import SaveSystem.IGameSaver;
import org.apache.commons.lang3.time.StopWatch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class ClickerWindow implements IProgramWindow {


    private final List<IControlFactory> dashboardFactories;
    private final IControlFactory topBarFactory;

    private final IStringsProvider stringsProvider;
    private final StopWatch stopwatch = new StopWatch();
    private final IGameLoop gameLoop;

    private final IGameSaver saver;

    public ClickerWindow(List<IControlFactory> dashboardFactories, IControlFactory topBarFactory, IStringsProvider stringsProvider, IGameLoop gameLoop, IGameSaver saver) {
        this.dashboardFactories = dashboardFactories;
        this.topBarFactory = topBarFactory;
        this.stringsProvider = stringsProvider;
        this.gameLoop = gameLoop;
        this.saver = saver;
    }

    private final JPanel mainPanel = new JPanel();

    @Override
    public void Start() {

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(topBarFactory.CreateControl());

        JPanel dashboardPanel = new JPanel(new GridLayout());
        for (IControlFactory factory : dashboardFactories)
            dashboardPanel.add(factory.CreateControl());

        mainPanel.add(dashboardPanel);

        JFrame frame = new JFrame(stringsProvider.GetStringFor(StringId.Title));
        frame.setLocationRelativeTo(null);
        frame.setContentPane(this.mainPanel);
        frame.setPreferredSize(new Dimension(500, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saver.SaveGame();
            }
        });
        frame.setVisible(true);


        stopwatch.start();

        float timeSinceLastSave = 0.0f;
        while (true) {
            System.nanoTime();
            if (stopwatch.getTime() > 0.1f)
            {
                gameLoop.Update(stopwatch.getTime() / 1000.0f);
                stopwatch.reset();
                stopwatch.start();
                timeSinceLastSave++;
            }
            if (timeSinceLastSave > 20)
            {
                saver.SaveGame("save.kekw.autobackup");
                timeSinceLastSave = 0;
            }
        }
    }
}
