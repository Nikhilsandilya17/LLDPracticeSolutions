package SOLID.src.dependencyinversionprinciple.BetterSolution;

public class DIPDemoBetter {
    public static void main(String[] args) {
        User user = new User(new PSql());
        user.saveUser();
    }
}
