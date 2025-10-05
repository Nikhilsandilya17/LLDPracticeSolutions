package designPatterns.src.behaviourial_design_pattern.observer.observerExample1.observer;

import designPatterns.src.behaviourial_design_pattern.observer.observerExample1.observable.StockObservable;

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
