package CLI;

import ClickerGame.IClickerGameLoop;

/**
 * An interface used to display stats of currently owned items and other things.
 *
 * Making this an entire seperate strategy seems like overkill until you learn about
 * Linux terminal powerusers.
 */
public interface IInformationDisplayingStrategy {
    void DisplayStats();
}