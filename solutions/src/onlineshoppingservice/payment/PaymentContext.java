package onlineshoppingservice.payment;

public class PaymentContext {
    private Payment paymentMethod;

    public PaymentContext(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void process(int amount){
        if(paymentMethod.pay(amount)){

            System.out.println("Payment of amount: "+amount+ " was success");
        }
        else {
            System.out.println("Payment failed");
        }
    }
}
