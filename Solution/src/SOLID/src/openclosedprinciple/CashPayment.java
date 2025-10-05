package SOLID.src.openclosedprinciple;

public class CashPayment implements ProcessPayment{
    @Override
    public void pay() {
        System.out.println("Processing cash payment...");
    }
}
