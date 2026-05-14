package designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.service;

import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.models.Card;

public class DebitCardManagerService implements CardManagerService{

    @Override
    public boolean validateCard(Card card, String pin) {
        //ideally we should make these also connect to API
         return true;
    }

    @Override
    public boolean validateWithdrawal(int transactionId, double amount) {
        return false;
    }

    @Override
    public boolean doTransaction(Card card, double amount, int transactionId) {
        return false;
    }
}
