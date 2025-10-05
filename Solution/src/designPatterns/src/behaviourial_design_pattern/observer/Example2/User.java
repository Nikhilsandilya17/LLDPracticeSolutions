package designPatterns.src.behaviourial_design_pattern.observer.Example2;

public class User implements Observer{

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received update: " + message);
    }

}
/**
 * Concrete observer
 */
