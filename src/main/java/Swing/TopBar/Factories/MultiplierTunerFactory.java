package Swing.TopBar.Factories;

import ClickerGame.Localization.IStringsProvider;
import ClickerGame.Localization.StringId;
import ClickerGame.World.IWorld;
import Swing.IControlFactory;
import Swing.TopBar.CustomControls.Mediator.FlipMediator;
import Swing.TopBar.CustomControls.TextUpdateObserver;
import Swing.TopBar.CustomControls.MultiplierButton;

import javax.swing.*;

public class MultiplierTunerFactory implements IControlFactory {

    private final IStringsProvider stringsProvider;
    private final IWorld world;

    private final static float MultiplierStepPerClick = 0.1f;

    public MultiplierTunerFactory(IStringsProvider stringsProvider, IWorld world) {
        this.stringsProvider = stringsProvider;
        this.world = world;
    }

    @Override
    public JComponent CreateControl() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        MultiplierButton actionMultiplierButton = new MultiplierButton(
                world::GetActionMultiplier,
                world::SetActionMultiplier,
                MultiplierStepPerClick);
        MultiplierButton buildingMultiplierButton = new MultiplierButton(
                world::GetBuildingMultiplier,
                world::SetBuildingMultiplier,
                MultiplierStepPerClick
        );

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
