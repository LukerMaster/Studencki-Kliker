package ClickerGame.Actions;

import java.util.List;
import java.util.NoSuchElementException;

public class CustomActionIterator implements Iterator<ICustomUserAction> {
    private final List<ICustomUserAction> actions;
    private int currentIndex = 0;

    public CustomActionIterator(List<ICustomUserAction> actions) {
        this.actions = actions;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < actions.size();
    }

    @Override
    public ICustomUserAction next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more actions.");
        }
        return actions.get(currentIndex++);
    }
}
