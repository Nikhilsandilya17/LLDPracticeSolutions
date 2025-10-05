package designPatterns.src.creational_design_pattern.prototye.approach3;

public class PrototypeDemo {
    public static void main(String[] args) {
        Email email = new Email("This is subject of Email", "This is a body of email");
        Email email2 = email.copy();  //Create a copy object
        PremiumEmail premiumEmail = new PremiumEmail("This is subject of Premium Email", "This is a body of Premium email", "This is a premium feature");
        PremiumEmail premiumEmail2 = premiumEmail.copy(); // calling copy method
        System.out.println(email2.toString());
        System.out.println(premiumEmail2.toString());
        //Now driver dont decide which copy to call
        //Now the obejct in itself will decide will copy constrcutor to call
    }
}
