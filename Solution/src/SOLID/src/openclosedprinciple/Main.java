package SOLID.src.openclosedprinciple;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.pay("CREDIT_CARD");
        payment.pay("DEBIT_CARD");
        payment.pay("UPI");
        payment.pay("NET_BANKING");
        payment.pay("CASH");

    }
}