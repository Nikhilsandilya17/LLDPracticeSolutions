package designPatterns.src.creational_design_pattern.prototye.approach2;

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

    //Copy constructor
    public Email(Email email) {
        this.subject = email.subject;
        this.body = email.body;
        this.recipient = email.recipient;
        this.cc = email.cc;
        this.bcc = email.bcc;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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

    @Override
    public String toString() {
        return "Email{" +
                "subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", recipient='" + recipient + '\'' +
                ", cc='" + cc + '\'' +
                ", bcc='" + bcc + '\'' +
                '}';
    }
}
