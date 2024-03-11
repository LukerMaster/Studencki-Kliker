package SaveSystem;

import ClickerGame.Actions.*;
import ClickerGame.World.*;
import Swing.ObservableInventory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldSaver implements IWorldProvider, IGameSaver {


    private IWorld world;

    private final String filePath;

    public WorldSaver(String filePath)
    {
        this.filePath = filePath;
        if (SaveExists())
            this.world = LoadGame();
        else
        {
            CreateNewGame();
        }
    }

    private List<ICustomUserAction> GetUserActions(IInventory inv, Random rng)
    {
        List<ICustomUserAction> availableActions = new ArrayList<>();

        availableActions.add(new ChopTree(inv));
        availableActions.add(new CollectStones(inv));
        availableActions.add(new HuntForSomething(inv));
        availableActions.add(new SearchForPlants(inv, rng));
        availableActions.add(new BrewBeer(inv));

        return availableActions;
    }

    private void CreateNewGame() {
        Random rng = new Random();

        ObservableInventory observableInventory = new ObservableInventory(new Inventory());

        List<ICustomUserAction> availableActions = GetUserActions(observableInventory, rng);

        this.world = new World(observableInventory, availableActions, rng);
    }

    public void SaveGame()
    {
        try {
            FileOutputStream fout = new FileOutputStream("save.kekw");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(world);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private IWorld LoadGame()
    {
        try
        {
            FileInputStream fileIn = new FileInputStream("save.kekw");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            IWorld world = (IWorld) in.readObject();
            world.SetAvailableActions(GetUserActions(world.GetInventory(), world.GetRng()));
            return world;
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
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
