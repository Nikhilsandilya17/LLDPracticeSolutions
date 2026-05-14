package designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.service;

import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.models.Card;

public interface CardManagerService {
    boolean validateCard(Card card, String pin);
    boolean validateWithdrawal(int transactionId, double amount);
    boolean doTransaction(Card card, double amount, int transactionId);

}
