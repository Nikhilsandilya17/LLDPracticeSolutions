package designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.state;

import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.DTO.CreateTransactionRequestDto;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.apis.BackendAPI;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.apis.NodeBackendAPI;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.enums.ATMState;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.models.ATM;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.models.Card;

public class ReadyForTransactionState implements State{

    private final ATM atm;
    private final BackendAPI backendAPI; // referring concrete class(violating DIP), so make a BackendAPI interface

    public ReadyForTransactionState(ATM atm, NodeBackendAPI backendAPI) {
        this.atm = atm;
        this.backendAPI = new NodeBackendAPI();
    }

    @Override
    public int initTransaction() {
        CreateTransactionRequestDto createTransactionRequestDto = new CreateTransactionRequestDto(atm.getAtmId());
        int transactionId = backendAPI.createTransaction(createTransactionRequestDto);
        if(transactionId == 0){
            throw new RuntimeException("Transaction id cannot be 0");
        }
        //Now that we have the transactionId from backend, we should move the ATM to the next state
        this.atm.changeState(new CardReadingState(atm));
        return transactionId;
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, String pin) {
        throw new IllegalStateException("Cannot read card details and pin when starting a transaction, as there is no card present");
    }

    @Override
    public int dispenseCash(Card card, int amount, int transactionId) {
        throw new IllegalStateException("Cannot dispense cash");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject card when starting a transaction, as there is no card present");
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, int transactionId, int amount) {
        throw new IllegalStateException("Cannot read cash withdrawal without reading card details and pin");
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        throw new IllegalStateException("Cannot cancel transaction");
    }

    @Override
    public ATMState getATMState() {
        return ATMState.READY_FOR_TRANSACTION;
    }
}
/**
 * Ideally in this state only initTransaction should happen
 */