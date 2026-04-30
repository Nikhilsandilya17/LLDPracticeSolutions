package designPatterns.src.creational_design_pattern.factory.factorySanket.better;

public class CoffeeFactory {
    public Coffee getCoffee(String type) {
        if(type.equalsIgnoreCase("Espresso")){
            return new Espresso();
        } else if(type.equalsIgnoreCase("Latte")){
            return new Latte();
        } else if(type.equalsIgnoreCase("Cappucino")){
            return new Cappucino();
        }
        return null;
    }
}
/**
 * in a factory, tghi factory class is the only class which vioaltes DIP
 * but it is meant to vioalte DIP
 * factory does not have business logic
 * it is only responsbile for creating objects
 */