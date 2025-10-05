package designPatterns.src.behaviourial_design_pattern.observer.observerExample1.observable;


import designPatterns.src.behaviourial_design_pattern.observer.observerExample1.observer.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneStockObservable implements StockObservable{

    List<NotificationObserver> notificationObservers = new ArrayList<>();
    int stockCount =0;

    @Override
    public void add(NotificationObserver notificationObserver) {
        notificationObservers.add(notificationObserver);
    }

    @Override
    public void remove(NotificationObserver notificationObserver) {
        notificationObservers.remove(notificationObserver);
    }

    @Override
    public void notifySubscribers() {
        //Now whosoever is observer to this (here in this context all the customers who have chosen to get
        //notified when new stock arrives

        for(NotificationObserver notificationObserver: notificationObservers){
            notificationObserver.update();
        }
    }

    @Override
    public void setStockCount(int newStockCount) {

        if(stockCount==0){
            notifySubscribers();
        }
        stockCount += newStockCount;
        if(newStockCount==0){
            stockCount=0;
        }
    }

    @Override
    public int getStockCount() {
        return 0;
    }
}
