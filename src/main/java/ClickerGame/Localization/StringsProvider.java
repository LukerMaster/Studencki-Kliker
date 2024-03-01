package ClickerGame.Localization;

import ClickerGame.Actions.CustomActionId;
import ClickerGame.ItemId;

import java.util.ResourceBundle;

public class StringsProvider implements IStringsProvider {

    final ResourceBundle textsBundle;

    public StringsProvider(ResourceBundle textsBundle)
    {
        this.textsBundle = textsBundle;
    }

    @Override
    public String GetNameForItem(ItemId Id) {
        return this.textsBundle.getString("Item_Name__" + Id.name());
    }

    @Override
    public String GetNameForAction(CustomActionId Id) {
        return this.textsBundle.getString("Action_Name__" + Id.name());
    }

    @Override
    public String GetNameForGenerator(GeneratorId Id) {
        return this.textsBundle.getString("Generator_Name__" + Id.name());
    }

    @Override
    public String GetStringFor(StringId Id) {
        return this.textsBundle.getString("String__" + Id.name());
    }
}
