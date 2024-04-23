package Swing.TopBar.Factories;

import Swing.IControlFactory;

import javax.swing.*;
import java.util.List;

public class TopBar implements IControlFactory {

    private final List<IControlFactory> controlsInTopBar;

    public TopBar(List<IControlFactory> controlsInTopBar) {
        this.controlsInTopBar = controlsInTopBar;
    }

    @Override
    public JComponent CreateControl() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        for (var control : controlsInTopBar)
        {
            mainPanel.add(control.CreateControl());
        }

        return mainPanel;
    }
}
