package openclosedprinciple;

public class DebitPayment implements ProcessPayment{
    @Override
    public void pay() {
        System.out.println("Processing debit card payment...");
    }
}
