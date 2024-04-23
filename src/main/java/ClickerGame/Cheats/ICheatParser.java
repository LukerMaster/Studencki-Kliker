package ClickerGame.Cheats;

import java.util.List;

public interface ICheatParser {
    List<IExpression> evaluate(String text);
}
