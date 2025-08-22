package behaviourial_design_pattern.observer.observerExample1.observable;

import behaviourial_design_pattern.observer.observerExample1.observer.NotificationObserver;

public interface StockObservable {
    //It will have all the methods like add, remove, update, setData, notify

    void add(NotificationObserver notificationObserver);

    void remove(NotificationObserver notificationObserver);

    void notifySubscribers();

    void setStockCount(int newStockCount);

    int getStockCount();

}
