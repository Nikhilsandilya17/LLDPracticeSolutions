package creational_design_pattern.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        SingletonService singletonService = SingletonService.getInstance();
        singletonService.display();
    }
}
