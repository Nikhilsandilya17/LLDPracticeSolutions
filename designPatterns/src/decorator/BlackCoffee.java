package decorator;

public class BlackCoffee implements Coffee{

    @Override
    public int getCost() {
        return 200;
    }

    @Override
    public String getDescription() {
        return "This is a Black Coffee";

    }
}
