package behaviourial_design_pattern.observer.Example2;

public class ObserverDemo {
    public static void main(String[] args) {
        NotificationService notificationService = NotificationService.getInstance();
        User user1 = new User("Nikhil");
        User user2 = new User("Sandy");

        notificationService.registerObserver(user1);
        notificationService.registerObserver(user2);

        notificationService.notifyObservers("Hello");
    }
}
