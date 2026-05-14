package designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.models;

import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.enums.CardType;

public class VisaDebitCard extends Card implements Visa, Debit{


    public VisaDebitCard(long cardNumber, int pin, String name, CardType cardType, String bankName) {
        super(cardNumber, pin, name, cardType, bankName);
    }

    @Override
    public void makePinPayment() {
        this.connectToVisa();
    }

    @Override
    public void connectToVisa() {
        System.out.println("Connecting to Visa network for card: ");
    }
}
