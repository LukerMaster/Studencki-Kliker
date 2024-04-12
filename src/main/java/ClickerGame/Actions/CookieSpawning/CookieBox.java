package ClickerGame.Actions.CookieSpawning;

import java.util.List;

public class CookieBox implements IHasCookies {
    
    private List<Cookie> cookieList;
    
    @Override
    public int GetCookies() {
        int count = 0;
        for (int i = 0; i < cookieList.size(); i++)
        {
            count += cookieList.get(i).GetCookies();
        }
        return count;
    }
}
