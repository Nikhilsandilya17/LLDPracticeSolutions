package designPatterns.src.creational_design_pattern.prototye.approach2;

public class PrototypeDemo {
    public static void main(String[] args) {
        Email email = new Email("This is subject of Email", "This is a body of email");
//       Email email1 = new Email(email); //Using copy constructor
        Email email2 = new PremiumEmail();
        if(email2 instanceof Email){
            email2 = new Email(email);
        }
        else if(email2 instanceof PremiumEmail){
            email2 = new PremiumEmail((PremiumEmail) email);
        }
        System.out.println(email2.toString());


    }
}
