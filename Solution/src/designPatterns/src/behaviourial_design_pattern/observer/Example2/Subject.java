package designPatterns.src.behaviourial_design_pattern.observer.Example2;

public interface Subject {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

/**
 * Subject interface
 * This interface defines the methods that a subject must implement to manage observers.
 */

