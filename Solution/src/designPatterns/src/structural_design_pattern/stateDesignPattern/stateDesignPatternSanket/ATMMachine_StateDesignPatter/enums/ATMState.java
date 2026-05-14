package designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.enums;

public enum ATMState {
    READY_FOR_TRANSACTION,
    READ_CARD_DETAILS_AND_PIN,
    DISPENSING_CASH,
    EJECTING_CARD,
    READING_CASH_WITHDRAWAL_DETAILS,
}
//cancellation is not a state
//it is what which will return us to ready state