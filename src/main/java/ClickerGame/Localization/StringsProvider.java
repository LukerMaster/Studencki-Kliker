package ClickerGame.Localization;

import ClickerGame.Actions.ICustomUserAction;
import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.IPeriodicProgressingAction;
import ClickerGame.Generators.GenerationStrategies.Actions.IChanceBased;
import ClickerGame.Generators.GenerationStrategies.Actions.IItemSpawning;
import ClickerGame.Generators.GenerationStrategies.Actions.IItemTaking;
import ClickerGame.Generators.GenerationStrategies.Actions.NoAction;
import ClickerGame.Generators.GenerationStrategies.StartConditions.IItemRequirement;
import ClickerGame.Generators.GenerationStrategies.StartConditions.NoRequirements;
import ClickerGame.Generators.IGenerator;
import ClickerGame.Generators.States.IState;
import ClickerGame.ItemId;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class StringsProvider implements IStringsProvider {

    final ResourceBundle textsBundle;


    public StringsProvider(ResourceBundle textsBundle)
    {
        this.textsBundle = textsBundle;
    }

    @Override
    public String GetNameForItem(ItemId Id) {
        return this.textsBundle.getString("Item_Name." + Id.name());
    }

    @Override
    public String GetNameForAction(ICustomUserAction Action) {
        return this.textsBundle.getString("Action_Name." + Action.getName());
    }

    @Override
    public String GetTooltipForAction(ICustomUserAction Action) {
        return this.textsBundle.getString("Action_Tooltip." + Action.getName());
    }

    @Override
    public String GetNameForGenerator(IGenerator Generator) {
        return this.textsBundle.getString("Generator_Name." + Generator.getClass().getSimpleName());
    }

    @Override
    public String GetNameForGeneratorState(IState State) {

        return this.textsBundle.getString("Generator.State." + State.getName());
    }

    @Override
    public String GetGenerationDescription(IGeneration Generation) {
        String template = textsBundle.getString("Generation.Type." + Generation.getClass().getSimpleName());

        if (Generation instanceof IPeriodicProgressingAction)
        {
            template = String.format(template, ((IPeriodicProgressingAction) Generation).GetWorkTime());
        }

        String requirement = "";
        if (Generation.GetRequirement().getClass() != NoRequirements.class)
        {
            requirement = textsBundle.getString("Generation.Requirement");
            requirement += ":\n" + textsBundle.getString("Generation.Requirement." + Generation.GetRequirement().getClass().getSimpleName());

            if (Generation.GetRequirement() instanceof IItemRequirement)
            {
                requirement += ":\n" + FormatItemsAsString(((IItemRequirement) Generation.GetRequirement()).GetItemsNeeded());
            }
        }

        String onStart = "";
        if (Generation.GetOnStart().getClass() != NoAction.class)
        {
            onStart = textsBundle.getString("Generation.OnStart");
            onStart += ":\n" + textsBundle.getString("Generation.Actions." + Generation.GetOnStart().getClass().getSimpleName());

            if (Generation.GetOnStart() instanceof IItemTaking)
            {
                onStart += ":\n" + FormatItemsAsString(((IItemTaking) Generation.GetOnStart()).GetItemsTaken());
            }
        }

        String onFinish = textsBundle.getString("Generation.OnFinish");
        onFinish += ":\n" + textsBundle.getString("Generation.Actions." + Generation.GetOnFinish().getClass().getSimpleName());

        if (Generation.GetOnFinish() instanceof IChanceBased)
        {
            onFinish = String.format(onFinish, ((IChanceBased) Generation.GetOnFinish()).GetChance() * 100);
        }
        if (Generation.GetOnFinish() instanceof IItemSpawning)
        {
            onFinish += ":\n" + FormatItemsAsString(((IItemSpawning) Generation.GetOnFinish()).GetItemsSpawned());
        }

        String finalString = template + "\n" + requirement + "\n" + onStart + "\n" + onFinish;

        return finalString;
    }

    @Override
    public String GetNameForScrappingType(ScrappingTypeId Id) {
        return textsBundle.getString("Scrapping.Type." + Id.name());
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

