package onlineshoppingservice.payment.impl;

import onlineshoppingservice.enums.PaymentStatus;
import onlineshoppingservice.payment.Payment;

public class CreditCardService extends Payment {

    private String cardHolderName;
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public CreditCardService(String cardHolderName, String cardNumber, String cvv, String expiryDate) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }


    @Override
    public boolean pay(int amount) {
        System.out.println("Processing payment using Credit Card of amount:" + amount);
        updatePaymentStatus(PaymentStatus.DONE);
        return true;
    }
}
