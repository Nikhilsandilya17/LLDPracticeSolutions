package designPatterns.src.creational_design_pattern.prototye.approach1;

public class Email {
    private String subject;
    private String body;
    private String recipient;
    private String cc;
    private String bcc;

    public Email() {
    }

    public Email(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }


    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }
}
