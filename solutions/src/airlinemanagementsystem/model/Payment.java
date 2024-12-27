package airlinemanagementsystem.model;

import airlinemanagementsystem.enums.PaymentMode;
import airlinemanagementsystem.enums.SeatType;

public abstract class Payment {
    private int paymentId;
    private PaymentMode paymentMode;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public abstract void processPayment(SeatType seatType);

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
}
