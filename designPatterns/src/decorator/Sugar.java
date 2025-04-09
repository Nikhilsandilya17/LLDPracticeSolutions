package decorator;

public class Sugar extends CoffeeDecorator{
    Coffee coffee;

    public Sugar(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getCost() {
        return this.coffee.getCost() + 10;
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription() + " with Sugar";
    }

}
