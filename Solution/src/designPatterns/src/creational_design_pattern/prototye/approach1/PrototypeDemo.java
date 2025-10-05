package designPatterns.src.creational_design_pattern.prototye.approach1;

public class PrototypeDemo {
    public static void main(String[] args) {
        Email email = new Email("This is subject of Email", "This is a body of email");
        Email email2 = new Email();
        extracted(email2, email);
        Email email3 = new Email();
        extracted(email3, email);
        //This violates DRY principle
        // DRY - Dont repeat yourself
        //this also violates OCP - Open closed principle
    }

    private static void extracted(Email email2, Email email) {
        email2.setRecipient(email.getRecipient());
        email2.setBody(email.getBody());
        email2.setSubject(email.getSubject());
        email2.setBcc(email.getBcc());
        email2.setCc(email.getCc());
    }

}
