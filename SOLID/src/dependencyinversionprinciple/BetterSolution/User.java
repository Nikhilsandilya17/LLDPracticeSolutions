package dependencyinversionprinciple.BetterSolution;

public class User {
    UserDatabase userDatabase;

    public User(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public void saveUser(){
        userDatabase.saveUser();
    }
}
