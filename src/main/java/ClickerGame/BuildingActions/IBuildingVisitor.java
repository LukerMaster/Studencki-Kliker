package ClickerGame.BuildingActions;


import ClickerGame.Generators.IGenerator;

public interface IBuildingVisitor {
    void visit(IGenerator g);
}
