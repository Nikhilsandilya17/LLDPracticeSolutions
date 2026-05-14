package designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.service;

import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.models.Card;

public class CreditCardManagerService implements CardManagerService{

    @Override
    public boolean validateCard(Card card, String pin) {
        return true;
    }

    @Override
    public boolean validateWithdrawal(int transactionId, double amount) {
        return true;
    }

    @Override
    public boolean doTransaction(Card card, double amount, int transactionId) {
        return true;
    }
}
