package CLI;

import ClickerGame.IClickerGameLoop;
import ClickerGame.IStringsProvider;
import ClickerGame.ItemId;
import ClickerGame.StringId;

import java.util.ResourceBundle;

public class InlineInformationDisplayingStrategy implements IInformationDisplayingStrategy {

    IClickerGameLoop gameLoop;
    IStringsProvider stringsProvider;

    public InlineInformationDisplayingStrategy(IClickerGameLoop gameLoop,
                                               IStringsProvider stringsProvider)
    {
        this.gameLoop = gameLoop;
        this.stringsProvider = stringsProvider;
    }

    @Override
    public void DisplayStats() {
        System.out.println(stringsProvider.GetStringFor(StringId.Your_Resources) + ":");

        for (ItemId id : ItemId.values())
            System.out.println(stringsProvider.GetNameForItem(id) + ": " + gameLoop.GetInventory().getCount(id));

        System.out.println(stringsProvider.GetStringFor(StringId.What_are_we_doing_next));
    }
}
