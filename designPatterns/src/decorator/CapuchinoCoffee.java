package decorator;

public class CapuchinoCoffee implements Coffee{
    @Override
    public int getCost() {
        return 300;
    }

    @Override
    public String getDescription() {
       return "This is a Capuchino Coffee";
    }
}
