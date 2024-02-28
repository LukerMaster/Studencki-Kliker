package CLI.Strategies;

import ClickerGame.Actions.IUserAction;
import ClickerGame.Localization.IStringsProvider;
import ClickerGame.World.IWorld;
import ClickerGame.ItemId;
import ClickerGame.Localization.StringId;

import java.util.ListIterator;

public class InlineInformationDisplayingStrategy implements IInformationDisplayingStrategy {

    IWorld world;
    IStringsProvider stringsProvider;

    public InlineInformationDisplayingStrategy(IWorld world,
                                               IStringsProvider stringsProvider)
    {
        this.world = world;
        this.stringsProvider = stringsProvider;
    }

    @Override
    public void DisplayStats() {
        System.out.println(stringsProvider.GetStringFor(StringId.Your_Resources) + ":");

        for (ItemId id : ItemId.values())
            System.out.println(stringsProvider.GetNameForItem(id) + ": " + world.GetInventory().getCount(id));

        ListIterator<IUserAction> uai = world.GetAvailableActions().listIterator();
        while (uai.hasNext())
            System.out.println((uai.nextIndex()+1) + ". " + stringsProvider.GetStringFor(uai.next().getInternalNameStringId()));

        System.out.println(stringsProvider.GetStringFor(StringId.What_are_we_doing_next));
    }
}
