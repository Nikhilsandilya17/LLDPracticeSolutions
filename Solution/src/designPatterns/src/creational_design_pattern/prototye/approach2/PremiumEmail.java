package designPatterns.src.creational_design_pattern.prototye.approach2;

public class PremiumEmail extends Email{
    private String premiumFeature;

    public PremiumEmail() {
        super();
    }

    //Copy constructor
    public PremiumEmail(PremiumEmail premiumEmail) {
        super(premiumEmail);
        this.premiumFeature = premiumEmail.premiumFeature;
    }

    public PremiumEmail(String subject, String body, String premiumFeature) {
        super(subject, body);
        this.premiumFeature = premiumFeature;
    }

    public String getPremiumFeature() {
        return premiumFeature;
    }

    public void setPremiumFeature(String premiumFeature) {
        this.premiumFeature = premiumFeature;
    }

    @Override
    public String toString() {
        return "PremiumEmail{" +
                "premiumFeature='" + premiumFeature + '\'' +
                ", subject='" + getSubject() + '\'' +
                ", body='" + getBody() + '\'' +
                '}';
    }

}
