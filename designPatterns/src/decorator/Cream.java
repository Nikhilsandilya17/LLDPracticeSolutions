package decorator;

public class Cream extends CoffeeDecorator{
    Coffee coffee;

    public Cream(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getCost() {
        return this.coffee.getCost() + 20;
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription() + " plus Cream";

    }
}
