package SOLID.src.dependencyinversionprinciple.BetterSolution;

public class Mongo implements UserDatabase{
    @Override
    public void saveUser() {
        System.out.println("Saving user to MongoDB");
    }
}
