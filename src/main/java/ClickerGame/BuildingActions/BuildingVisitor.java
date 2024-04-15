package ClickerGame.BuildingActions;

import ClickerGame.Generators.CustomGenerators.HopsBush;
import ClickerGame.Generators.CustomGenerators.SmallTreeFarm;
import ClickerGame.Generators.IGenerator;
import ClickerGame.Generators.StandardGenerators.Brewery;

public class BuildingVisitor implements IBuildingVisitor {

    private static final float SmallHelpTime = 0.1f;
    private static final float MediumHelpTime = 0.25f;
    private static final float BigHelpTime = 0.5f;
    private static final float HugeHelpTime = 1.0f;


    @Override
    public void visit(IGenerator g)
    {
        // I prefer this over double dispatch. Less coupling and not much more code.
        switch (g) {
            case Brewery brewery -> visit(brewery);
            case SmallTreeFarm smallTreeFarm -> visit(smallTreeFarm);
            case HopsBush bush -> visit(bush);
            case null, default -> defaultVisit(g);
        }
    }

    private void defaultVisit(IGenerator g)
    {
        g.Update(SmallHelpTime);
    }

    public void visit(Brewery b) {
        b.Update(MediumHelpTime);
    }

    public void visit(SmallTreeFarm farm) {
        farm.Update(HugeHelpTime);
    }

    public void visit(HopsBush bush) {
        bush.Update(MediumHelpTime);
    }
}
