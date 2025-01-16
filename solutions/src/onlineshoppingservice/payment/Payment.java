package onlineshoppingservice.payment;

import onlineshoppingservice.enums.PaymentStatus;

public abstract class Payment {
    protected PaymentStatus paymentStatus;

    public Payment() {
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public abstract boolean pay(int amount);

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    protected void updatePaymentStatus(PaymentStatus status) {
        this.paymentStatus = status;
    }

}
