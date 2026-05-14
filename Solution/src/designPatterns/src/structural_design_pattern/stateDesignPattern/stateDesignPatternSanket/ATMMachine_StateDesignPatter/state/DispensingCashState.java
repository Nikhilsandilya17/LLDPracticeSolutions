package designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.state;

import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.enums.ATMState;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.factory.CardManagerFactory;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.models.ATM;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.models.Card;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.service.CardManagerService;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.service.CashDispenseServiceImpl;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.service.CashDispenserService;

public class DispensingCashState implements State{

    private final ATM atm;
    private final CashDispenserService cashDispenserService;

    public DispensingCashState(ATM atm) {
        this.atm = atm;
        this.cashDispenserService = new CashDispenseServiceImpl();
    }

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot init transaction while dispensing cash");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, String pin) {
       throw new IllegalStateException("Cannot read card details and pin while dispensing cash");
    }

    @Override
    public int dispenseCash(Card card, int amount, int transactionId) {
        CardManagerService cardManagerService = CardManagerFactory.getCardManager(card.getCardType());
        boolean isTransactionSuccess = cardManagerService.doTransaction(card, amount, transactionId); // amount is not required here as we have already validated the withdrawal details in the previous state
        if(isTransactionSuccess) {
            this.cashDispenserService.dispenseCash(this.atm, amount);
            this.atm.changeState(new EjectingCardState(this.atm));
        }
        else {
            System.out.println("Something went wrong");
            this.atm.changeState(new EjectingCardState(this.atm));
        }
        return amount;
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject card while dispensing cash");
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, int transactionId, int amount) {
        throw new IllegalStateException("Cannot read cash withdrawal details while dispensing cash");
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        throw new IllegalStateException("Cannot cancel transaction while dispensing cash");
    }

    @Override
    public ATMState getATMState() {
        return ATMState.DISPENSING_CASH;
    }
}
