package designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.state;

import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.enums.ATMState;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.factory.CardManagerFactory;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.models.ATM;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.models.Card;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.service.CardManagerService;

public class CardReadingState implements State{
    private final ATM atm;

    public CardReadingState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Transaction already initialized. Card is being read.");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, String pin) {
        // Here we can have logic to read card details and pin, and validate them
        // For simplicity, let's assume the card is always valid
        CardManagerService cardManager = CardManagerFactory.getCardManager(card.getCardType());
        boolean isCardValid = cardManager.validateCard(card, pin);
        if(isCardValid) {
            this.atm.changeState(new ReadingCashWithdrawalDetailsState());
        }else {
            this.atm.changeState(new EjectingCardState(atm)); // passing null for backendAPI for simplicity
        }
        return true;
    }

    @Override
    public int dispenseCash(Card card, int amount, int transactionId) {
        throw new IllegalStateException("Cannot dispense cash. Card is being read.");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject card while reading card details. Please wait.");
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, int transactionId, int amount) {
        throw new IllegalStateException("Cannot read cash withdraw details. Card is being read.");
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        this.atm.changeState(new ReadyForTransactionState(atm, null));
        return true;
    }

    @Override
    public ATMState getATMState() {
        return ATMState.READ_CARD_DETAILS_AND_PIN;
    }
}
