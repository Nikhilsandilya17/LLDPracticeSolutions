package dependencyinversionprinciple;

public class DIPDemo {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.saveUser();
    }
}
