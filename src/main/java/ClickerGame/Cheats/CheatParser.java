package ClickerGame.Cheats;

import java.util.ArrayList;
import java.util.List;

public class CheatParser {

    public IExpression[] evaluate(String text)
    {
        String[] statements = text.split(";");
        List<IExpression> expressions = new ArrayList<>();
        for (var statement:statements) {
            statement.split(" ");
        }
        return null; // TODO
    }
}
