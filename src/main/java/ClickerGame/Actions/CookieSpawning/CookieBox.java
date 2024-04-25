package ClickerGame.Actions.CookieSpawning;

import java.util.List;

public class CookieBox implements IHasCookies {

    private final List<Cookie> cookieList;

    public CookieBox(List<Cookie> list)
    {
        cookieList = list;
    }

    @Override
    public int GetCookies() {
        return cookieList.stream()
                .mapToInt(Cookie::GetCookies)
                .sum();
    }
}
