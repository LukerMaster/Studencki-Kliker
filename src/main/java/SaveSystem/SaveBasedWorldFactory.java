package SaveSystem;

import ClickerGame.Actions.*;
import ClickerGame.Actions.CookieSpawning.CookieSpawnActionWrapper;
import ClickerGame.World.*;
import Swing.ObservableInventory;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SaveBasedWorldFactory implements IWorldFactory, IGameSaver {


    private IWorld world;

    private final String filePath;

    public SaveBasedWorldFactory(String filePath)
    {
        this.filePath = filePath;
        if (SaveExists())
            this.world = LoadGame();
        else
        {
            CreateNewGame();
        }
    }

    private List<ICustomUserAction> GetUserActions(IInventory inv, Random rng, float multiplier)
    {
        List<ICustomUserAction> rawActions = new ArrayList<>();


        rawActions.add(new CollectWood(inv));
        rawActions.add(new CollectStones(inv));
        rawActions.add(new HuntForSomething(inv, rng));
        rawActions.add(new SearchForPlants(inv, rng));
        rawActions.add(new BrewBeer(inv));

        CookieSpawnActionWrapper wrapper = new CookieSpawnActionWrapper(rng);
        List<ICustomUserAction> wrappedActions = new ArrayList<>();
        for (ICustomUserAction action: rawActions) {
            wrappedActions.add(wrapper.WrapActionWithCookieSpawn(action, inv));
            action.setPowerMultiplier(multiplier);
        }

        return wrappedActions;
    }

    private void CreateNewGame() {
        Random rng = new Random();

        ObservableInventory observableInventory = new ObservableInventory(new InventoryWithHoles(new Inventory(), rng));

        List<ICustomUserAction> availableActions = GetUserActions(observableInventory, rng, 1);

        this.world = new World(observableInventory, availableActions, rng);
    }

    @Override
    public void SaveGame(String filePath)
    {
        try {
            FileOutputStream fout = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            world.SetLastGameTime(Instant.now());
            oos.writeObject(world);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void SaveGame() {
        SaveGame("save.kekw");
    }

    private IWorld LoadGame()
    {
        try
        {
            FileInputStream fileIn = new FileInputStream("save.kekw");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            IWorld world = (IWorld) in.readObject();
            world.SetAvailableActions(GetUserActions(world.GetInventory(), world.GetRng(), world.GetActionMultiplier()));
            EmulateTimeOffline(world);
            return world;
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void EmulateTimeOffline(IWorld world) {
        float TotalTimeOffline = Instant.now().getEpochSecond() - world.GetLastGameTime().getEpochSecond();
        world.GetActiveGenerators().forEach(g -> g.Update(TotalTimeOffline));

    }

    public boolean SaveExists()
    {
        File f = new File(filePath);
        return f.exists() && !f.isDirectory();
    }

    @Override
    public IWorld GetWorld() {
        return world;
    }
}
