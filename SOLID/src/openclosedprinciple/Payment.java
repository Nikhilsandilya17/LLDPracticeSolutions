package openclosedprinciple;

public class Payment {
    public void pay(String paymentType){
        if(paymentType == "CREDIT_CARD"){
            System.out.println("Credit card");
        }
        else if(paymentType == "DEBIT_CARD"){
            System.out.println("Debit card");
        }
        else if(paymentType == "UPI"){
            System.out.println("UPI");
        }
        else if(paymentType == "NET_BANKING"){
            System.out.println("Net Banking");
        }

        //adding new else-if is called modifiation = means updating the current class
        // I have 10 more payment types
        else{
            System.out.println("Invalid payment type");
        }
    }
}



