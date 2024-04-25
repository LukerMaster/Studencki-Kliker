package Tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import ClickerGame.Cheats.AddItemExpression;
import ClickerGame.Cheats.CheatParser;
import ClickerGame.Cheats.IExpression;
import org.junit.jupiter.api.Test;
class CheatParserTest {
    @Test
    void shouldAddItemWhenCommandIsValid() {
        CheatParser parser = new CheatParser();
        String input = "add Wood 10;";
        List<IExpression> result = parser.evaluate(input);

        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof AddItemExpression);
        AddItemExpression expression = (AddItemExpression) result.get(0);
        assertEquals("add", expression.getAction());
        assertEquals("Wood", expression.getItem());
        assertEquals(10, expression.getAmount());
    }

    @Test
    void shouldRemoveItemWhenCommandIsValid() {
        CheatParser parser = new CheatParser();
        String input = "remove Stone 5;";
        List<IExpression> result = parser.evaluate(input);

        assertEquals(1, result.size());
        assertTrue(result.get(0) instanceof AddItemExpression);
        AddItemExpression expression = (AddItemExpression) result.get(0);
        assertEquals("remove", expression.getAction());
        assertEquals("Stone", expression.getItem());
        assertEquals(5, expression.getAmount());
    }

    @Test
    void shouldReturnEmptyListWhenCommandIsInvalid() {
        CheatParser parser = new CheatParser();
        String input = "INVALIDCOMMAND DDDDD Wood 10;";
        List<IExpression> result = parser.evaluate(input);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnEmptyListWhenItemIdIsInvalid() {
        CheatParser parser = new CheatParser();
        String input = "add CocaCola 10;";
        List<IExpression> result = parser.evaluate(input);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnEmptyListWhenAmountFormatIsInvalid() {
        CheatParser parser = new CheatParser();
        String input = "add Wood 1..05.;";
        List<IExpression> result = parser.evaluate(input);

        assertTrue(result.isEmpty());
    }



}


