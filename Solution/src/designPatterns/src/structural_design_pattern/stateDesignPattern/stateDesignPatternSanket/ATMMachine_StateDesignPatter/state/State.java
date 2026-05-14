package designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.state;

import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.enums.ATMState;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.models.Card;

public interface State {

    int initTransaction();
    boolean readCardDetailsAndPin(Card card, String pin); //return true if card is valid
    int dispenseCash(Card card, int amount, int transactionId);
    void ejectCard();
    boolean readCashWithdrawDetails(Card card, int transactionId, int amount);
    boolean cancelTransaction(int transactionId);
    ATMState getATMState();
}
/**
 * we will make classes implementing this state interface
 * and then implementing these methods under those classes
 * showing how will methods behave under specific states
 */