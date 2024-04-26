package Swing.TopBar.Factories;

import ClickerGame.Cheats.ICheatParser;
import ClickerGame.Localization.IStringsProvider;
import ClickerGame.Localization.StringId;
import ClickerGame.World.IWorld;
import Swing.IControlFactory;

import javax.swing.*;

public class CheatConsoleFactory implements IControlFactory {

    final IStringsProvider stringsProvider;
    final IWorld world;

    final ICheatParser parser;

    public CheatConsoleFactory(IStringsProvider stringsProvider, IWorld world, ICheatParser parser) {
        this.stringsProvider = stringsProvider;
        this.world = world;
        this.parser = parser;
    }

    @Override
    public JComponent CreateControl() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        JTextArea inputArea = new JTextArea();
        JButton executeButton = new JButton(stringsProvider.GetStringFor(StringId.Execute));
        executeButton.addActionListener((b) ->
        {
           var expressions = parser.evaluate(inputArea.getText());
           for (var exp : expressions)
           {
               exp.interpret(world);
           }
           inputArea.setText("");
        });

        mainPanel.add(inputArea);
        mainPanel.add(executeButton);

        return mainPanel;
    }
}
