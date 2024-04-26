package Swing.TopBar.Factories;

import Swing.IControlFactory;

import javax.swing.*;
import java.util.List;

public class TopBarFactory implements IControlFactory {

    private final List<IControlFactory> controlsInTopBar;

    public TopBarFactory(List<IControlFactory> controlsInTopBar) {
        this.controlsInTopBar = controlsInTopBar;
    }

    @Override
    public JComponent CreateControl() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        controlsInTopBar.stream().forEach(control -> mainPanel.add(control.CreateControl()));

        return mainPanel;
    }
}
