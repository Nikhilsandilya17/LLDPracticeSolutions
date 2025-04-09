package decorator;

public class CoffeeDemo {
    public static void main(String[] args) {
        System.out.println("Welcome to Coffee Machine");
        Coffee coffee = new BlackCoffee();
        System.out.println("Cost of first coffee: " + coffee.getCost());
        Coffee coffee1 = new Cream(new ExpressoCoffee());
        System.out.println("Cost of second coffee: " + coffee1.getCost());
        Coffee coffee2 = new Cream(new Sugar(new Milk(new BlackCoffee())));
        System.out.println("Cost of third coffee: " + coffee2.getCost());
    }
}
