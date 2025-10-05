package designPatterns.src.structural_design_pattern.decorator;

public class ExpressoCoffee implements Coffee{
    @Override
    public int getCost() {
        return 500;
    }

    @Override
    public String getDescription() {
        return "This is a Expresso Coffee";
    }
}
