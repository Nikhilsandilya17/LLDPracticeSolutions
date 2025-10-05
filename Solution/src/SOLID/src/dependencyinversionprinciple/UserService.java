package SOLID.src.dependencyinversionprinciple;

public class UserService {
    UserDatabase userDatabase = new UserDatabase();

    public void saveUser(){
        userDatabase.saveUser();
    }
}
