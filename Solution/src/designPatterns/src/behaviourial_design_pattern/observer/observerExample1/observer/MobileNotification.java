package designPatterns.src.behaviourial_design_pattern.observer.observerExample1.observer;

import designPatterns.src.behaviourial_design_pattern.observer.observerExample1.observable.StockObservable;

public class MobileNotification implements NotificationObserver{
    StockObservable stockObservable;
    String phoneNo;

    public MobileNotification(StockObservable stockObservable, String phoneNo) {
        this.stockObservable = stockObservable;
        this.phoneNo = phoneNo;
    }

    @Override
    public void update() {
        sendMsg(stockObservable, phoneNo);
    }

    private void sendMsg(StockObservable stockObservable, String msg) {
        System.out.println("Message sent to: "+ phoneNo);
    }
}
