package designPatterns.src.creational_design_pattern.prototye.approach3;

public class PremiumEmail extends Email{
    private String premiumFeature;

    public PremiumEmail() {
        super();
    }

    public PremiumEmail(String subject, String body, String premiumFeature) {
        super(subject, body);
        this.premiumFeature = premiumFeature;
    }

    //Copy constructor
    public PremiumEmail(PremiumEmail premiumEmail) {
        super(premiumEmail);
        this.premiumFeature = premiumEmail.premiumFeature;
    }

    public String getPremiumFeature() {
        return premiumFeature;
    }

    @Override
    public PremiumEmail copy() {
        return new PremiumEmail(this); //calling copy constructor
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
