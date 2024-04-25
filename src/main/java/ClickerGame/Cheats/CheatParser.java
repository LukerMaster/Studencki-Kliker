package ClickerGame.Cheats;

import ClickerGame.ItemId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheatParser implements ICheatParser {

    public List<IExpression> evaluate(String text)
    {
        String[] statements = text.split(";");
        List<IExpression> expressions = new ArrayList<>();
        for (var statement : statements) {
            statement = statement.trim();
            var parts = statement.split(" ");
            if (isValid_AddOrRemoveItem_String(parts))
            {
                expressions.add(new AddItemExpression(parts[0], parts[1], Integer.parseInt(parts[2])));
            }
        }
        return expressions;
    }

    private boolean isValid_AddOrRemoveItem_String(String[] parts) {
        return parts.length == 3 &&
                (parts[0].equals("add") || parts[0].equals("remove")) &&
                Arrays.stream(ItemId.values()).anyMatch(p -> p.name().equals(parts[1])) &&
                parts[2].matches("-?\\d+");
    }
}
