package Swing.TopBar.Factories;

import ClickerGame.Localization.IStringsProvider;
import ClickerGame.Localization.StringId;
import Swing.IControlFactory;
import Swing.TopBar.CustomControls.Mediator.FlipMediator;
import Swing.TopBar.CustomControls.Mediator.TextUpdateObserver;
import Swing.TopBar.CustomControls.MultiplierButton;

import javax.swing.*;

public class TopBarFactory implements IControlFactory {

    private final IStringsProvider stringsProvider;

    public TopBarFactory(IStringsProvider stringsProvider) {
        this.stringsProvider = stringsProvider;
    }

    @Override
    public JComponent CreateControl() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        MultiplierButton actionMultiplierButton = new MultiplierButton();
        MultiplierButton buildingMultiplierButton = new MultiplierButton();

        var textUpdateObserver = new TextUpdateObserver(
                actionMultiplierButton,
                buildingMultiplierButton,
                stringsProvider.GetStringFor(StringId.ActionMultiplier),
                stringsProvider.GetStringFor(StringId.BuildingMultiplier));
        textUpdateObserver.UpdateTexts();

        actionMultiplierButton.addActionListener((b) -> {
            actionMultiplierButton.Increase();
            textUpdateObserver.UpdateTexts();
        });
        buildingMultiplierButton.addActionListener(b -> {
            buildingMultiplierButton.Increase();
            textUpdateObserver.UpdateTexts();
        });

        // It feels so odd that you just don't store this anywhere.
        new FlipMediator(actionMultiplierButton, buildingMultiplierButton);

        panel.add(actionMultiplierButton);
        panel.add(buildingMultiplierButton);
        return panel;
    }
}
