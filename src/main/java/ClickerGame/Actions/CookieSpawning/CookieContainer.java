package ClickerGame.Actions.CookieSpawning;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CookieContainer implements IHasCookies {

    private final List<IHasCookies> containers = new ArrayList<>();

    private static final float containerSpawnChance = 0.7F;
    private static final float cookieSpawnChance = 0.4F;
    private static final float cookieBoxSpawnChance = 0.2F;

    @Override
    public int GetCookies() {
        return containers.stream()
                .mapToInt(IHasCookies::GetCookies)
                .sum();
    }

    static CookieContainer CreateRandomContainer(Random rng)
    {
        CookieContainer root = new CookieContainer();

        while (rng.nextFloat() > containerSpawnChance)
        {
            root.containers.add(CreateRandomContainer(rng));
        }
        while (rng.nextFloat() > cookieBoxSpawnChance)
        {
            List<Cookie> cookieList = new ArrayList<>();

            while (rng.nextFloat() > cookieSpawnChance)
            {
                cookieList.add(new Cookie());
            }

            root.containers.add(new CookieBox(cookieList));
        }
        while (rng.nextFloat() > cookieSpawnChance)
        {
            root.containers.add(new Cookie());
        }

        return root;
    }
}
