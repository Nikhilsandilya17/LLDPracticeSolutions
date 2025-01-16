package onlineshoppingservice.payment.impl;

import onlineshoppingservice.enums.PaymentStatus;
import onlineshoppingservice.payment.Payment;

public class UPIService extends Payment {
    private String upiId;

    public UPIService(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean pay(int amount) {
        System.out.println("Processing payment using UPI of amount:" + amount);
        updatePaymentStatus(PaymentStatus.CANCELLED);
        return true;
    }
}
