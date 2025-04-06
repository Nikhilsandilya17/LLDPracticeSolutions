package behaviourial_design_pattern.observer;

import behaviourial_design_pattern.observer.observable.IphoneStockObservable;
import behaviourial_design_pattern.observer.observable.StockObservable;
import behaviourial_design_pattern.observer.observer.EmailNotification;
import behaviourial_design_pattern.observer.observer.MobileNotification;
import behaviourial_design_pattern.observer.observer.NotificationObserver;


public class Stock {

    public static void main(String[] args){
        StockObservable stockObservable = new IphoneStockObservable();

        //Make subscribers who will get notified
        NotificationObserver observer1 = new EmailNotification("nikhil", stockObservable);
        NotificationObserver observer2 = new MobileNotification(stockObservable, "anand");

        //Add these observers
        stockObservable.add(observer1);
        stockObservable.add(observer2);

        //Call setStockCount such that observers or users are notified
        stockObservable.setStockCount(20);
        stockObservable.setStockCount(100);

        stockObservable.setStockCount(0);
        stockObservable.remove(observer2);
        stockObservable.setStockCount(30);


    }





}
