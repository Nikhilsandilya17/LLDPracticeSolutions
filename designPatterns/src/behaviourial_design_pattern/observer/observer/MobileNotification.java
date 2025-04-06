package behaviourial_design_pattern.observer.observer;

import behaviourial_design_pattern.observer.observable.StockObservable;

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
