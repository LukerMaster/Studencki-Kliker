package Swing;

import ClickerGame.Localization.IStringsProvider;
import ClickerGame.Localization.StringId;
import Core.IProgramWindow;
import Swing.Dashboards.IDashboardFactory;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ClickerWindow implements IProgramWindow {


    private List<IDashboardFactory> dashboardFactories;
    private IStringsProvider stringsProvider;

    public ClickerWindow(List<IDashboardFactory> dashboardFactories, IStringsProvider stringsProvider) {
        this.dashboardFactories = dashboardFactories;
        this.stringsProvider = stringsProvider;
    }

    private JPanel mainPanel = new JPanel();

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
    }
}
