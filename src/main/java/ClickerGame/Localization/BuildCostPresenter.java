package ClickerGame.Localization;

import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuildCostPresenter implements IBuildCostPresenter {

    private final IStringsProvider stringsProvider;

    public BuildCostPresenter(IStringsProvider stringsProvider) {
        this.stringsProvider = stringsProvider;
    }

    public String PresentCostAsString(Map<ItemId, BigInteger> cost)
    {
        List<String> itemRepresentations = new ArrayList<>();
        for (Map.Entry<ItemId, BigInteger> entry : cost.entrySet())
        {
            itemRepresentations.add(entry.getValue() + " " + stringsProvider.GetNameForItem(entry.getKey()));
        }

        return String.join("<br/>", itemRepresentations);
    }
}
