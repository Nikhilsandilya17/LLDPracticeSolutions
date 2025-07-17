package structural_design_pattern.decorator;

public class Milk extends CoffeeDecorator{

    Coffee coffee;

    public Milk(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getCost() {
        return coffee.getCost() + 40;
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription() + " plus Milk";
    }
}
