package SOLID.src.dependencyinversionprinciple.BetterSolution;

public class Sql implements UserDatabase{
    @Override
    public void saveUser() {
        System.out.println("Saving user to SQL Database");
    }
}
