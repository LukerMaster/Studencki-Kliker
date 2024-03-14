package ClickerGame.Generators;

import ClickerGame.Generators.GenerationStrategies.IGeneration;
import ClickerGame.Generators.GenerationStrategies.IPeriodicProgressingAction;
import ClickerGame.Generators.GenerationStrategies.Actions.SimpleItemSpawning;
import ClickerGame.Generators.GenerationStrategies.Actions.NoAction;
import ClickerGame.Generators.GenerationStrategies.PeriodicAction;
import ClickerGame.Generators.GenerationStrategies.StartConditions.OneTimeOnly;
import ClickerGame.Generators.Scraping.IScrappable;
import ClickerGame.ItemId;
import ClickerGame.Localization.ScrappingTypeId;
import ClickerGame.World.IInventory;

import java.math.BigInteger;
import java.util.Map;

public class SmallTree implements IGenerator, IMadeOutOf, IScrappable {

    private final IGeneration strategy;
    private final IPeriodicProgressingAction growth;

    public SmallTree(IInventory inventory)
    {
        strategy = new PeriodicAction(15,
                new OneTimeOnly(),
                new NoAction(),
                new NoAction());
        growth = (IPeriodicProgressingAction) strategy;
    }
    @Override
    public IGeneration GetGenerationStrategy() {
        return strategy;
    }

    @Override
    public Map<ItemId, BigInteger> GetWhatItsMadeOutOf() {
        return Map.of(ItemId.Wood, new BigInteger("40"),
                ItemId.Stone, new BigInteger("8"));
    }

    @Override
    public Map<ItemId, BigInteger> GetScrapValue() {
        int woodAmount = (int) (growth.GetProgressToNextSpawn() * growth.GetProgressToNextSpawn() * 150);
        return Map.of(ItemId.Wood, new BigInteger(String.valueOf(woodAmount)));
    }

    @Override
    public ScrappingTypeId GetScrappingType()
    {
        return ScrappingTypeId.CutDown;
    }
}