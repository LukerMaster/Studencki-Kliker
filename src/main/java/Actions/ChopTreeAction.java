package Actions;

import Core.IInventory;
import Core.ItemId;

public class ChopTreeAction implements IUserAction {

    IInventory userInventory;

    public ChopTreeAction(IInventory userInventory) {
        this.userInventory = userInventory;
    }

    @Override
    public String getInternalName() {
        return "chop_tree";
    }

    @Override
    public void execute() {
        userInventory.addItems(ItemId.Wood, 1);
    }
}
