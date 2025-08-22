package behaviourial_design_pattern.observer.Example2;

import java.util.ArrayList;
import java.util.List;

public class NotificationService implements Subject{

    List<Observer> observers = new ArrayList<>();
    private static NotificationService instance;

    public static synchronized NotificationService getInstance(){
        if(instance == null){
            instance = new NotificationService();
        }
        return instance;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for(Observer observer: observers){
            observer.update(message);
        }
    }
}

/**
 * Concrete subject
 * This class implements the Subject interface and manages a list of observers.
 * It provides methods to register, remove, and notify observers.
 */
