package SOLID.src.dependencyinversionprinciple.BetterSolution;

public class PSql implements UserDatabase{

    @Override
    public void saveUser() {
        System.out.println("Saving user to PSQL Database");
    }
}
