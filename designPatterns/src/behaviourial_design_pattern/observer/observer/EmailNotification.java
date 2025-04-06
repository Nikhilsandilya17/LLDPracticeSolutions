package behaviourial_design_pattern.observer.observer;

import behaviourial_design_pattern.observer.observable.StockObservable;

public class EmailNotification implements NotificationObserver{
    StockObservable stockObservable;
    String emailId;

    public EmailNotification(String emailId, StockObservable stockObservable) {
        this.stockObservable = stockObservable;
        this.emailId = emailId;

    }

    @Override
    public void update() {
        sendEmail(emailId, "Product is back");
    }

    private void sendEmail(String emailId, String msg) {
        System.out.println("Mail sent to: " + emailId);
    }
}
