package CLI.Strategies;

import ClickerGame.Actions.ICustomUserAction;
import ClickerGame.Localization.IStringsProvider;
import ClickerGame.World.IWorld;
import ClickerGame.ItemId;
import ClickerGame.Localization.StringId;

import java.util.ListIterator;

public class InformationDisplayingInTerminal implements IInformationDisplaying {

    IWorld world;
    IStringsProvider stringsProvider;

    public InformationDisplayingInTerminal(IWorld world,
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

        ListIterator<ICustomUserAction> uai = world.GetAvailableActions().listIterator();
        while (uai.hasNext())
            System.out.println((uai.nextIndex()+1) + ". " + stringsProvider.GetNameForAction(uai.next().GetActionId()));

        System.out.println(stringsProvider.GetStringFor(StringId.What_are_we_doing_next));
    }
}
