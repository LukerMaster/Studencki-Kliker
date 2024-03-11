package ClickerGame.Localization;

import ClickerGame.Actions.ICustomUserAction;
import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.IGenerator;
import ClickerGame.ItemId;
import ClickerGame.Localization.GenerationPresenters.IGenerationPresentingStrategy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class StringsProvider implements IStringsProvider {

    final ResourceBundle textsBundle;
    final IGenerationPresentingStrategy presenter;


    public StringsProvider(ResourceBundle textsBundle, IGenerationPresentingStrategy presenter)
    {
        this.textsBundle = textsBundle;
        this.presenter = presenter;
    }

    @Override
    public String GetNameForItem(ItemId Id) {
        return this.textsBundle.getString("Item_Name." + Id.name());
    }

    @Override
    public String GetNameForAction(ICustomUserAction Action) {
        return this.textsBundle.getString("Action_Name." + Action.getClass().getSimpleName());
    }

    @Override
    public String GetNameForGenerator(IGenerator Generator) {
        return this.textsBundle.getString("Generator_Name." + Generator.getClass().getSimpleName());
    }

    @Override
    public String GetGenerationDescription(IGeneration Generation) {
        String template = textsBundle.getString("Generation_Description." + Generation.getClass().getSimpleName());
        return presenter.GetFormattedRepresentation(template, Generation, this);
    }

    @Override
    public String GetStringFor(StringId Id) {
        return this.textsBundle.getString("String." + Id.name());
    }

    @Override
    public String FormatItemsAsString(Map<ItemId, BigInteger> items)
    {
        List<String> itemRepresentations = new ArrayList<>();
        for (Map.Entry<ItemId, BigInteger> entry : items.entrySet())
        {
            itemRepresentations.add(entry.getValue() + " " + GetNameForItem(entry.getKey()));
        }

        return String.join("\n", itemRepresentations);
    }
}

