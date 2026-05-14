package designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.state;

import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.enums.ATMState;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.factory.CardManagerFactory;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.models.ATM;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.models.Card;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.service.CardManagerService;

public class ReadingCashWithdrawalDetailsState implements State{
    private final ATM atm;

    public ReadingCashWithdrawalDetailsState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot init transaction");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, String pin) {
        throw new IllegalStateException("Cannot read card details and pin");
    }

    @Override
    public int dispenseCash(Card card, int amount, int transactionId) {
        throw new IllegalStateException("Cannot dispense cash");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject card");
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, int transactionId, int amount) {
        CardManagerService cardManagerService = CardManagerFactory.getCardManager(card.getCardType());
        boolean isWithdrawalValid = cardManagerService.validateWithdrawal(transactionId, amount);
        if (!isWithdrawalValid) {
            this.atm.changeState(new DispensingCashState(atm));
        }
        else  {
            this.atm.changeState(new EjectingCardState(atm));
        }
        return true;
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        this.atm.changeState(new ReadyForTransactionState(atm, null));
        return true;
    }

    @Override
    public ATMState getATMState() {
        return ATMState.READING_CASH_WITHDRAWAL_DETAILS;
    }
}
