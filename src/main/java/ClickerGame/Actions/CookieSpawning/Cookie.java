package ClickerGame.Actions.CookieSpawning;

public class Cookie implements IHasCookies {

    private final int CookieCount = 1;

    @Override
    public int GetCookies() {
        return CookieCount;
    }
}
